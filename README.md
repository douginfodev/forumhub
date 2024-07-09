# forumhub
Challenge 03 - ONE - Oracle Next Education

        <dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>
		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-mysql</artifactId>
		</dependency>


        @Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}

server.port=2500
spring.application.name=forumhub
spring.datasource.url=jdbc:postgresql://localhost:5432/one_literalura
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.HSQLDialect

traduzir os parametros da paginacao
spring.data.web.pageable.page-parameter=pagina
spring.data.web.pageable.size-parameter=tamanho
spring.data.web.sort.sort-parameter=ordem

create table topicos{
  id int(11) not null auto_increment,
  titulo varchar(100) not null,
  mensagem varchar(250) not null,
  datatopico varchar(10) not null,
  statustopico varchar(10) not null,
  autor int(3) not null,
  curso varchar(50) not null,
  respostas varchar(250) not null,

  primary key(id)
};
