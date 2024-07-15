package com.douginfodev.forumhub.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
//import com.douginfodev.forumhub.infra.security.TokenService;

import com.douginfodev.forumhub.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{
  
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var tokenJWT = recuperarToken(servletRequest);
        
        if (tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT); 
            var usuario = repository.findByLogin(subject);
        
           var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
           SecurityContextHolder.getContext().setAuthentication(authentication); 
        }
         
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String recuperarToken(HttpServletRequest request){
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null){
            //throw new RuntimeException("Authorization header nao enviado ou inválido");
            return authorizationHeader.replace("Bearer ","").trim();
        }

        return null;
    }
/* 
  @WebFilter(urlPatterns = "/api/**")
  
public class LogFilter implements Filter {
    @WebFilter(urlPatterns = "/api/**")
    public class LogFilter implements Filter {
    
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("Requisição recebida em: " + LocalDateTime.now());
            
            filterChain.doFilter(servletRequest, servletResponse);
        }
*/
}
