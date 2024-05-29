package com.contatos.gerenciadordecontatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contatos.gerenciadordecontatos.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
