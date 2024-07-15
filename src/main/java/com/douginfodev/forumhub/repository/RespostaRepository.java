package com.douginfodev.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.douginfodev.forumhub.domain.respostas.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Integer> {

}