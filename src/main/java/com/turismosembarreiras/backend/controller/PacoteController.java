package com.turismosembarreiras.backend.controller;

import com.turismosembarreiras.backend.model.Pacote;
import com.turismosembarreiras.backend.repository.AgenciaRepository;
import com.turismosembarreiras.backend.repository.PacoteRepository;
import com.turismosembarreiras.backend.repository.SaidaRepository;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    private final PacoteRepository repository;
    private final AgenciaRepository agenciaRepository;
    private final SaidaRepository saidaRepository;

    public PacoteController(PacoteRepository repository, AgenciaRepository agenciaRepository,
                            SaidaRepository saidaRepository) {
        this.repository = repository;
        this.agenciaRepository = agenciaRepository;
        this.saidaRepository = saidaRepository;
    }

    // GET /pacotes  ou  GET /pacotes?idAgencia=1
    @GetMapping
    public List<Pacote> listar(@RequestParam(required = false) Long idAgencia) {
        if (idAgencia != null) {
            return repository.findByIdAgencia(idAgencia);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pacote buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pacote não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pacote criar(@Valid @RequestBody Pacote dados) {
        if (!agenciaRepository.existsById(dados.getIdAgencia())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agência não encontrada");
        }
        dados.setIdPacote(null); // garante que vai criar um novo, nunca sobrescrever
        return repository.save(dados);
    }

    @PutMapping("/{id}")
    public Pacote atualizar(@PathVariable Long id, @Valid @RequestBody Pacote dados) {
        Pacote pacote = buscarPorId(id);

        // a agência dona do pacote não muda
        pacote.setIdDestino(dados.getIdDestino());
        pacote.setTitulo(dados.getTitulo());
        pacote.setDescricao(dados.getDescricao());
        pacote.setDuracao(dados.getDuracao());
        pacote.setPreco(dados.getPreco());
        pacote.setIncluso(dados.getIncluso());

        return repository.save(pacote);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        Pacote pacote = buscarPorId(id);

        if (saidaRepository.existsByIdPacote(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Este pacote possui saídas. Apague as saídas primeiro.");
        }
        try {
            repository.delete(pacote);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Este pacote está sendo usado em outros registros (imagens, acessibilidade etc.)");
        }
    }
}