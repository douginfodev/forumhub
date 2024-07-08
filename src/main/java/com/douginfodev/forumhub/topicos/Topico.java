package com.douginfodev.forumhub.topicos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
   
    private String titulo;
    private String mensagem;
    private String data;
    private String status;
    private String autor;
    private Integer curso;
    private String respostas;

    public Topico(DadosTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = dados.data();
        this.status = dados.status();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.respostas = dados.respostas();
    }


}
