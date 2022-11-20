package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.ProductModels;
import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepositories extends JpaRepository<ProductModels, Long> {
    boolean existsBynomeProduto(String nomeProduto);

    Optional<ProductModels> findBynomeProduto(String nomeProduto);

    Optional<ProductModels> findByid (long id);
}
