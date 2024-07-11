package com.douginfodev.forumhub.topicos;

public record DadosDetailsTopico(
    Integer id, 

 
    String titulo, 
  
    String mensagem, 

    String datatopico, 

    String statustopico,
   
    String autor,

    Integer curso, 
   
    String respostas

) {

    public DadosDetailsTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensagem(),topico.getDatatopico(),topico.getStatustopico(),topico.getAutor(),topico.getCurso(),topico.getRespostas());
    }

}
