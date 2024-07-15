package com.douginfodev.forumhub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douginfodev.forumhub.domain.usuario.DadosAutenticacao;
import com.douginfodev.forumhub.infra.security.DadosTokenJWT;
import com.douginfodev.forumhub.infra.security.TokenService;

import com.douginfodev.forumhub.domain.usuario.Usuario;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenservice;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenservice.gerarToken((Usuario) authentication.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
