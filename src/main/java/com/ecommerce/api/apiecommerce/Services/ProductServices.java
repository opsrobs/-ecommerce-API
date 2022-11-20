package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.ProductModels;
import com.ecommerce.api.apiecommerce.Repositories.ProductRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductServices {
    
    final ProductRepositories productRepositories;

    public ProductServices(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    @Transactional
    public ProductModels save(ProductModels ProductModels){
        return productRepositories.save(ProductModels);
    }

    public Optional<ProductModels> findById(long id) {
        return productRepositories.findById(id);
    }
    public Optional<ProductModels> findByid (long id) {
        return productRepositories.findByid(id);
    }

    public Page<ProductModels> findAll(Pageable pageable) {
        return productRepositories.findAll(pageable);
    }

    public boolean existsByNomeTipo(String nomeTipo){
        return productRepositories.existsBynomeProduto(nomeTipo);
    }
}
