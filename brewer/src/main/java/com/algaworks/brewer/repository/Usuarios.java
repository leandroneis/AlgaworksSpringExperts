package com.algaworks.brewer.repository;

import java.util.List;
import java.util.Optional;

import com.algaworks.brewer.repository.filter.UsuarioFilter;
import com.algaworks.brewer.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.brewer.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

    public Optional<Usuario> findByEmail(String email);

    public List<Usuario> findByCodigoIn(Long[] codigos);

   }