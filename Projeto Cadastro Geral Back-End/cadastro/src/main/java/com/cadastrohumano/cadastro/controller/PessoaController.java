package com.cadastrohumano.cadastro.controller;

import com.cadastrohumano.cadastro.model.Pessoa;
import com.cadastrohumano.cadastro.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*") // permite acesso externo (ex: do React)
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // GET /pessoas - listar todas
    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    // POST /pessoas - cadastrar nova
    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // GET /pessoas/{id} - buscar por ID
    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    // PUT /pessoas/{id} - atualizar pessoa
    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
        return pessoaRepository.findById(id).map(p -> {
            p.setNome(novaPessoa.getNome());
            p.setIdade(novaPessoa.getIdade());
            p.setEmail(novaPessoa.getEmail());
            p.setEndereco(novaPessoa.getEndereco());
            return pessoaRepository.save(p);
        }).orElse(null);
    }

    // DELETE /pessoas/{id} - deletar pessoa
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}
