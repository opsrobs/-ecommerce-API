package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Models.UserEmailModels;
import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.ecommerce.api.apiecommerce.Repositories.UserEmailRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
public class UserEmailService {
    final UserEmailRepositories userEmailRepositories;

    public UserEmailService(UserEmailRepositories userContatoRepositorie) {
        this.userEmailRepositories = userContatoRepositorie;
    }

    @Transactional
    public UserEmailModels save(UserEmailModels userEmailModels){
        return userEmailRepositories.save(userEmailModels);
    }

    public Optional<UserEmailModels> findById (long id){
        return userEmailRepositories.findById(id);
    }

    public Page<UserEmailModels> findAll(Pageable pageable) {
        return userEmailRepositories.findAll(pageable);
    }
}
