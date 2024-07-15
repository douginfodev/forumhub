# FORUM HUB ALURA - CHALLENGE 03
## Programa One - Oracle Next Education

## Sobre o projeto
Desenvolver toda a parte de back-end de um forum de estudos trabalhando com API rest e spring boot framework.

## OBJETIVOS
Nosso objetivo com este challenge é implementar uma API REST com as seguintes funcionalidades:

* API com rotas implementadas seguindo as melhores práticas do modelo REST;
* Validações realizadas segundo as regras de negócio;
* Implementação de uma base de dados relacional para a persistência da informação;
* Serviço de autenticação/autorização para restringir o acesso à informação.

## ROTAS

### Topico
<span style="color:lime>;">VERBO POST:</span> Criação de Tópico.
http://localhost:2500/topico

<span style="color:yellow;">VERBO GET:</span> Listar todos Tópicos
http://localhost:2500/topico

<span style="color:yellow;">VERBO GET:</span> Detalhamento de um Tópico pelo id.
http://localhost:2500/topico/1

<span style="color:blue;">VERBO PUT:</span> Atualizar tópico.
http://localhost:2500/topico/1

<span style="color:red;">VERBO DELETE:</span> Exclução Lógica de um tópico pelo id.
http://localhost:2500/topico/1

### Usuario
POST: Criação de usuário autorizado a acessar a API.
http://localhost:2500/login

## BANCO DE DADOS
<img src="https://github.com/douginfodev/forumhub/blob/main/img/bancofh.jpg" alt="modelo de dados">

## FERRAMENTAS
* spring boot
* java 22
* Mavem
* Validation
* Spring Data JPA
* Flyway Migration
* Bd Mysql

