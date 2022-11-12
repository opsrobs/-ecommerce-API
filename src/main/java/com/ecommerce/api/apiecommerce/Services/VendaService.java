package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.VendaModels;
import com.ecommerce.api.apiecommerce.Repositories.VendaRepositories;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
