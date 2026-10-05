package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Saida;
import com.turismosembarreiras.backend.repository.PacoteRepository;
import com.turismosembarreiras.backend.repository.SaidaRepository;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/saidas")
public class SaidaController {

    private final SaidaRepository repository;
    private final PacoteRepository pacoteRepository;

    public SaidaController(SaidaRepository repository, PacoteRepository pacoteRepository) {
        this.repository = repository;
        this.pacoteRepository = pacoteRepository;
    }

    // GET /saidas  ou  GET /saidas?idPacote=1
    @GetMapping
    public List<Saida> listar(@RequestParam(required = false) Long idPacote) {
        if (idPacote != null) {
            return repository.findByIdPacote(idPacote);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Saida buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Saída não encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Saida criar(@Valid @RequestBody Saida dados) {
        if (!pacoteRepository.existsById(dados.getIdPacote())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pacote não encontrado");
        }
        validarDatas(dados);

        dados.setIdSaida(null);
        dados.setVagasDisponiveis(dados.getVagasTotal()); // saída nova começa com todas as vagas livres
        return repository.save(dados);
    }

    @PutMapping("/{id}")
    public Saida atualizar(@PathVariable Long id, @Valid @RequestBody Saida dados) {
        Saida saida = buscarPorId(id);
        validarDatas(dados);

        // vagas já reservadas = total antigo - disponíveis atuais
        int reservadas = saida.getVagasTotal() - saida.getVagasDisponiveis();
        if (dados.getVagasTotal() < reservadas) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "vagasTotal não pode ser menor que as vagas já reservadas (" + reservadas + ")");
        }

        saida.setDataSaida(dados.getDataSaida());
        saida.setDataRetorno(dados.getDataRetorno());
        saida.setPreco(dados.getPreco());
        saida.setVagasTotal(dados.getVagasTotal());
        saida.setVagasDisponiveis(dados.getVagasTotal() - reservadas);
        // vagasDisponiveis NUNCA vem do front: só muda por reserva ou por vagasTotal

        return repository.save(saida);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        Saida saida = buscarPorId(id);
        try {
            repository.delete(saida);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Esta saída possui reservas e não pode ser apagada.");
        }
    }

    private void validarDatas(Saida s) {
        if (s.getDataRetorno().isBefore(s.getDataSaida())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A data de retorno não pode ser antes da data de saída");
        }
    }
}