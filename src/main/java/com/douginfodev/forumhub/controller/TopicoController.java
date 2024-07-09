package com.douginfodev.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    /*
     * @GetMapping
     * public String getAll(){
     * return "OLA MUNDO";
     * }
     */

    @PostMapping
    @Transactional
    public void Insert(@RequestBody @Valid DadosTopico dados) {
        repository.save(new Topico(dados));
    }

    // 08000555090 *topico?sort=titulo,desc&size=10&page=0
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

}