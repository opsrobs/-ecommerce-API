package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.ecommerce.api.apiecommerce.Repositories.UserRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    final UserRepositories userRepositorie;

    public UserService(UserRepositories userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    @Transactional
    public PessoaModels save(PessoaModels PessoaModels){
        return userRepositorie.save(PessoaModels);
    }

    public boolean existsByUserName(String username){
        return userRepositorie.existsByUserName(username);
    }
    public Page<PessoaModels> findAll(Pageable pageable) {
        return userRepositorie.findAll(pageable);
    }

    public Optional<PessoaModels> findById (long id){
        return userRepositorie.findById(id);
    }

    public PessoaModels loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PessoaModels> usuario = userRepositorie.findByUserName(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }


        return new PessoaModels(username);
    }
    public Optional<PessoaModels> findByUserName (String username){
        return userRepositorie.findByUserName(username);
    }

}
