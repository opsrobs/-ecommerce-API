package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.BairroModels;
import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;
import com.ecommerce.api.apiecommerce.Repositories.BairroRepositories;
import com.ecommerce.api.apiecommerce.Repositories.CityRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BairroServices {
    final BairroRepositories bairroRepositories;

    public BairroServices(BairroRepositories bairroRepositories) {
        this.bairroRepositories = bairroRepositories;
    }

    @Transactional
    public BairroModels save(BairroModels bairroModels){
        return bairroRepositories.save(bairroModels);
    }

    public Optional<BairroModels> findById(long id) {
        return bairroRepositories.findById(id);
    }

    public boolean existsBynomeBairro(String nomeTipo){
        return bairroRepositories.existsBynomeBairro(nomeTipo);
    }

    public Page<BairroModels> findAll(Pageable pageable) {
        return bairroRepositories.findAll(pageable);
    }
}
