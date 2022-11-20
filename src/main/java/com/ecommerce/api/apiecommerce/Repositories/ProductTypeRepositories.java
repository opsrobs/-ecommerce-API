package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductTypeRepositories extends JpaRepository <ProductTypeModels, Long> {

    boolean existsByNomeTipo(String nomeTipo);

    Optional<ProductTypeModels> findByNomeTipo(String nomeTipo);
}
