package com.douginfodev.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.douginfodev.forumhub.domain.respostas.DadosAtualizacaoResposta;
import com.douginfodev.forumhub.domain.respostas.DadosDetailsResposta;
import com.douginfodev.forumhub.domain.respostas.DadosListagemResposta;
import com.douginfodev.forumhub.domain.respostas.DadosResposta;
import com.douginfodev.forumhub.domain.respostas.Resposta;
import com.douginfodev.forumhub.repository.RespostaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity Insert(@RequestBody @Valid DadosRespota dados, UriComponentsBuilder uriBuilder) {
       var reposta = new Resposta(dados);
       repository.save(reposta);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetailsResposta(resposta));
    }

    //topicos?sort=titulo,desc&size=10&page=0
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> ListAll(@PageableDefault(size = 10, sort = { "datatopico" }) Pageable paginacao) {
        var pageDados = repository.findAll(paginacao).map(DadosListagemResposta::new);
        return  ResponseEntity.ok(pageDados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity Update(@RequestBody @Valid DadosAtualizacaoResposta dados) {
       var topico = repository.getReferenceById(dados.id());
       topico.atualizarResposta(dados);

       return ResponseEntity.ok(new DadosDetailsResposta(resposta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Delete(@PathVariable Integer id) {
       repository.deleteById(id);

       return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Integer id) {
       var resposta = repository.getReferenceById(id);

       return ResponseEntity.ok(new DadosDetailsResposta(resposta));
   
    }

}