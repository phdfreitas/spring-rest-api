package com.desafio.spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.spring.restapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
