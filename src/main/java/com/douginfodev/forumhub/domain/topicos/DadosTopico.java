package com.douginfodev.forumhub.topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosTopico(
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
    String autor,
    @NotBlank
    Integer curso, 
    @NotBlank
    String respostas) {

}
