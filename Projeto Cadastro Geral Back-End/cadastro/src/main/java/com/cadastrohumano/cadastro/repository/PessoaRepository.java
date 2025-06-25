package com.cadastrohumano.cadastro.repository;

import com.cadastrohumano.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}

