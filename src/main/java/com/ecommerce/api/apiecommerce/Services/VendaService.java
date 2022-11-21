package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.EnderecoModels;
import com.ecommerce.api.apiecommerce.Models.VendaModels;
import com.ecommerce.api.apiecommerce.Repositories.VendaRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VendaService {
    final VendaRepositories vendaRepositories;

    public VendaService(VendaRepositories vendaRepositories) {
        this.vendaRepositories = vendaRepositories;
    }

    @Transactional
    public VendaModels save(VendaModels vendaModels){
        return vendaRepositories.save(vendaModels);
    }

    public Optional<VendaModels> findById(long id) {
        return vendaRepositories.findById(id);
    }

    public Page<VendaModels> findAll(Pageable pageable) {
        return vendaRepositories.findAll(pageable);
    }
}
