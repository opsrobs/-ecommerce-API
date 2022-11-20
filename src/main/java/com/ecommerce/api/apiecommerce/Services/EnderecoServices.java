package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.BairroModels;
import com.ecommerce.api.apiecommerce.Models.EnderecoModels;
import com.ecommerce.api.apiecommerce.Repositories.EnderecoRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServices {
    final EnderecoRepositories enderecoRepositories;

    public EnderecoServices(EnderecoRepositories enderecoRepositories) {
        this.enderecoRepositories = enderecoRepositories;
    }

    public EnderecoModels save(EnderecoModels enderecoModels){
        return enderecoRepositories.save(enderecoModels);
    }

    public Optional<EnderecoModels> findById(long id) {
        return enderecoRepositories.findById(id);
    }

    public Page<EnderecoModels> findAll(Pageable pageable) {
        return enderecoRepositories.findAll(pageable);
    }
}
