package com.douginfodev.forumhub.topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosListagemTopico(

        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String datatopico,
        @NotBlank String statustopico,
        @NotBlank String autor,
        @NotBlank Integer curso) {

        public DadosListagemTopico(Topico topico){
          this(topico.getTitulo(),topico.getMensagem(),topico.getDatatopico(),topico.getStatustopico(),topico.getAutor(),topico.getCurso());
        }

}
