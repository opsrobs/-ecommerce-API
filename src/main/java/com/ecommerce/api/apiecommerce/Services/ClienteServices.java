package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.ClienteModels;
import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.ecommerce.api.apiecommerce.Repositories.ClienteRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
public class ClienteServices {
    final ClienteRepositories clienteRepositories;

    public ClienteServices(ClienteRepositories clienteRepositories) {
        this.clienteRepositories = clienteRepositories;
    }

    @Transactional
    public ClienteModels save(ClienteModels clienteModels){
        return clienteRepositories.save(clienteModels);
    }

    public Page<ClienteModels> findAll(Pageable pageable) {
        return clienteRepositories.findAll(pageable);
    }


    public Optional<ClienteModels> findById(long id) {
        return clienteRepositories.findById(id);
    }

    public Optional<ClienteModels> findByPessoa(long id) {
        return clienteRepositories.findByPessoa(id);
    }
}
