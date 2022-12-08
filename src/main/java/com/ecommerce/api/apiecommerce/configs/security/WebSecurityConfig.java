package com.ecommerce.api.apiecommerce.configs.security;

import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.ecommerce.api.apiecommerce.Services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                        .authorizeRequests().antMatchers(HttpMethod.GET, "").permitAll()
//                        .anyRequest().authenticated()
//                        .and()
//                                .addFilter(new JWTAutenticateFilter(authentication -> ))
//                                        .addFilter(new JWTValidateFilter(authentication -> authentication))
//                                                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .cors()
                .and()
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "api/user-products").permitAll()
                .antMatchers(HttpMethod.GET, "/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/e-commerce/new-user").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/e-commerce/new-user").permitAll()
                .antMatchers(HttpMethod.GET, "/e-commerce/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user-products").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user-categories/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/e-commerce/").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(3600L);
        config.setAllowedOrigins(
                Arrays.asList("http://localhost:8082",
                        "http://localhost:8081")
        );

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}