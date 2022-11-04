package com.algaworks.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.brewer.model.Cidade;

import java.util.List;

public interface Cidades extends JpaRepository<Cidade, Long> {

    public List<Cidade> findByEstadoCodigo(Long codigoEstado);

}