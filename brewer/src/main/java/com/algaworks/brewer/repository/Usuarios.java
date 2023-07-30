package com.algaworks.brewer.repository;

import java.util.Optional;

import com.algaworks.brewer.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.brewer.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

    public Optional<Usuario> findByEmail(String email);

}