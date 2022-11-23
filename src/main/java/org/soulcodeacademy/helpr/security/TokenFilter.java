package org.soulcodeacademy.helpr.security;

import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//Token Filter, irá verificar as requisições do cliente uma ves por requisição;
//OncePerRequestFilter sempre que uma requisição é feita ele é ativado
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UsuarioSecurityService service;
//requisição que vem do cliente, a resposta e o filtro

    //Esse método é chamado toda requisição feita pelo cliente
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if(!validarCabecalho(request)){            //caso cabeçalho não seja valido, é porque o cliente errou a requisição, e
            filterChain.doFilter(request,response); // eu informo para os filtros encerrar
            return;
        }

        String token = this.extrairToken(request);

        if(!this.tokenUtil.validarToken(token)){    // se token não for válido
            filterChain.doFilter(request,response); // eu informo para os filtros encerrar
            return;
        }
    // Passo 4
        String email = this.tokenUtil.extrairEmail(token);
        UserDetails usuario = this.service.loadUserByUsername(email);
        // Configura o usuário encontrado como autenticado na aplicação
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities()));
        filterChain.doFilter(request, response);
        // Resumo: Extrair do cabeçalho as informações do token,
        // com base nessas informações busca dados do usuário e então indica
        // para a segurança da aplicação que o usuário válido
        // Os próximos filtros já irão conhecer usuário e permitir o acesso
    }

    // Passo 3
    private String extrairToken(HttpServletRequest request){
        //"Bearer <JWT>"
        String cabecalho = request.getHeader("Authorization");

        return cabecalho.substring(7); //Retorna apenas o código do <JWT>, evitando Bearer
    }




    //Passo 1 e 2
        private boolean validarCabecalho(HttpServletRequest request){
            // extrai do cliente o cabeçalho com o possiível token
            String cabecalho = request.getHeader("Authorization");
            //o cabeçalho enviado pelo cliente é valído se possuir o Authorization e o valor começar com "Bearer"
            return cabecalho != null && cabecalho.startsWith("Bearer"); // returna true se o cabeçalho for valido

    }
}
