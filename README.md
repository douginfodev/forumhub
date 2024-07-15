# FORUM HUB ALURA - CHALLENGE 03 - One - Oracle Next Education

## Sobre o projeto
O FórumHub é uma API REST desenvolvida em Java utilizando Spring Boot, que simula um fórum de discussão. Nesta API, os usuários podem criar, visualizar, atualizar e deletar tópicos de discussão, perfis, respostas, cursos e usuários. A partir de agora, apenas usuários autenticados podem interagir com a API. Este projeto é parte do desafio Challenge Back End.

## Funcionalidades / Rotas

### Topico
<span style="color:lime>;">VERBO POST: Criação de Tópico.
http://localhost:2500/topico

<span style="color:yellow;">VERBO GET: Listar todos Tópicos
http://localhost:2500/topico

<span style="color:yellow;">VERBO GET: Detalhamento de um Tópico pelo id.
http://localhost:2500/topico/1

<span style="color:blue;">VERBO PUT: Atualizar tópico.
http://localhost:2500/topico/1

<span style="color:red;">VERBO DELETE</span>: Exclução Lógica de um tópico pelo id.
http://localhost:2500/topico/1

### Usuario
POST: Criação de usuário autorizado a acessar a API.
http://localhost:2500/login
