package com.ecommerce.api.apiecommerce.configs.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticateFilter extends UsernamePasswordAuthenticationFilter {
    public static final int TOKEN_EXPIRATE = 600_000;
    public static final String TOKEN_SIGN= "0c4567eb-7822-4840-b24b-d465d6aa467a";
    private final AuthenticationManager authenticationManager;

    public JWTAutenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            PessoaModels user = new ObjectMapper().readValue(request.getInputStream(), PessoaModels.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUserName(),
                    user.getPassword(),
                    new ArrayList<>()
            ));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao auntenticar o usuario",e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        PessoaModels user = (PessoaModels) authResult.getPrincipal();
        String token = JWT.create().
                withSubject(user.getUserName()).
                        withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATE))
                                .sign(Algorithm.HMAC512(TOKEN_SIGN));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
