package com.douginfodev.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douginfodev.forumhub.repository.TopicoRepository;
import com.douginfodev.forumhub.topicos.DadosAtualizacaoTopico;
import com.douginfodev.forumhub.topicos.DadosListagemTopico;
import com.douginfodev.forumhub.topicos.DadosTopico;
import com.douginfodev.forumhub.topicos.Topico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void Insert(@RequestBody @Valid DadosTopico dados) {
        repository.save(new Topico(dados));
    }

    //topicos?sort=titulo,desc&size=10&page=0
    @GetMapping
    public Page<DadosListagemTopico> ListAll(@PageableDefault(size = 10, sort = { "datatopico" }) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    @PutMapping
    @Transactional
    public void Update(@RequestBody @Valid DadosAtualizacaoTopico dados) {
       var topico = repository.getReferenceById(dados.id());
       topico.atualizarTopico(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void Delete(@PathVariable Integer id) {
       repository.deleteById(id);
    }

}