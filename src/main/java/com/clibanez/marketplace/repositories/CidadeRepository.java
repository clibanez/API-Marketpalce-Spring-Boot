package com.clibanez.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clibanez.marketplace.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
