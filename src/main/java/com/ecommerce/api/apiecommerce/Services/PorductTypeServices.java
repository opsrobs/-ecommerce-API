package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;
import com.ecommerce.api.apiecommerce.Models.StadeModels;
import com.ecommerce.api.apiecommerce.Repositories.ProductTypeRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PorductTypeServices {

    final ProductTypeRepositories productTypeRepositories;

    public PorductTypeServices(ProductTypeRepositories productTypeRepositories) {
        this.productTypeRepositories = productTypeRepositories;
    }

    @Transactional
    public ProductTypeModels save(ProductTypeModels productTypeModels){
        return productTypeRepositories.save(productTypeModels);
    }

    public Optional<ProductTypeModels> findById(long id) {
        return productTypeRepositories.findById(id);
    }

    public Page<ProductTypeModels> findAll(Pageable pageable) {
        return productTypeRepositories.findAll(pageable);
    }

    public boolean existsByNomeTipo(String nomeTipo){
        return productTypeRepositories.existsByNomeTipo(nomeTipo);
    }
}
