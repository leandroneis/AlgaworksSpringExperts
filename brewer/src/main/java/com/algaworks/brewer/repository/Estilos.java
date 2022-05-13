package com.algaworks.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.model.Estilo;

import java.util.Optional;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {

    public Optional<Estilo> findByNomeIgnoreCase(String nome);
}