package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.BairroModels;
import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BairroRepositories extends JpaRepository<BairroModels, Long> {
    boolean existsBynomeBairro(String nomeTipo);
    
//    Optional<ProductTypeModels> findByNomeTipo(String nomeTipo);

}
