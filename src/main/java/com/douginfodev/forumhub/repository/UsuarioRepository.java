package com.douginfodev.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douginfodev.forumhub.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}