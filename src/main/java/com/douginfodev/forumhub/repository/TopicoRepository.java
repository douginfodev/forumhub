package com.douginfodev.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douginfodev.forumhub.domain.topicos.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Integer>{

}
