package com.douginfodev.forumhub.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
    @NotNull
    Integer id, 

    @NotBlank
    String titulo, 
    @NotBlank
    String mensagem, 
    @NotBlank
    String datatopico,
    @NotBlank
    String statustopico,
    @NotBlank 
    String autor
) {

}
