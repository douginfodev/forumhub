package com.douginfodev.forumhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douginfodev.forumhub.topicos.DadosTopico;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("topico")
public class TopicoController {
   
    @GetMapping
    public String getAll(){
        return "OLA MUNDO";
    }

    @PostMapping
    public void Insert(@RequestBody DadosTopico dados){
        System.out.println(dados);
    }

}
