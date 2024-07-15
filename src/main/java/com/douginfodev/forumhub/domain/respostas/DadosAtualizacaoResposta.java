package com.douginfodev.forumhub.domain.respostas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoResposta(
    @NotNull 
    Integer id, 

    @NotBlank
    String mensagem, 
    @NotNull
    Integer titulo, 
    @NotBlank
    String dataresposta, 
    @NotBlank 
    String autor,
    @NotBlank
    String resposta) {
}
