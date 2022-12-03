package com.ecommerce.api.apiecommerce.configs.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTValidateFilter extends BasicAuthenticationFilter {

    public static final String HEADER_ATTRIBUTE="Authorization";
    public static final String HEADER_PREFIX="Bearer ";

    public JWTValidateFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String atributo = request.getHeader(HEADER_ATTRIBUTE);

        if (atributo ==null && !atributo.startsWith(HEADER_PREFIX)){
            chain.doFilter(request,
                    response
            );
            return;
        }

        String token = atributo.replace(HEADER_ATTRIBUTE, "");
        UsernamePasswordAuthenticationToken  authenticationToken = getAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);


    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
        String user = JWT.require(Algorithm.HMAC512(JWTAutenticateFilter.TOKEN_SIGN)).
                build()
                .verify(token)
                .getSubject();
        if (user == null){
            return null;
        }
        return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
    }
}
