package com.douginfodev.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douginfodev.forumhub.repository.TopicoRepository;
import com.douginfodev.forumhub.topicos.DadosTopico;
import com.douginfodev.forumhub.topicos.Topico;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("topico")
public class TopicoController {
   
    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public String getAll(){
        return "OLA MUNDO";
    }

    @PostMapping
    public void Insert(@RequestBody DadosTopico dados){
        repository.save(new Topico(dados));
    }

}
