package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.ecommerce.api.apiecommerce.Repositories.UserRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

}
