package com.desafio.spring.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.spring.restapi.model.Pessoa;
import com.desafio.spring.restapi.service.PessoaDao;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    
    @Autowired
    private PessoaDao pessoaDao;

    @PostMapping
    public Pessoa getPessoaDao(@RequestBody Pessoa pessoa) {
        return pessoaDao.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> getPessoas() {
        return pessoaDao.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa getOne(@PathVariable Long id){
        Pessoa pessoa = pessoaDao.findOne(id);
        return pessoa;
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa pessoa2 = pessoaDao.findOne(id);
        
        pessoa2.setNome(pessoa.getNome());
        pessoa2.setIdade(pessoa.getIdade());
        pessoa2.setPosicaoFila(pessoa.getPosicaoFila());
        
        return pessoaDao.update(pessoa2);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Pessoa pessoa = pessoaDao.findOne(id);
        pessoaDao.delete(pessoa);
    }
}
