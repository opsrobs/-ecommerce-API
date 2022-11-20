package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.EnderecoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositories extends JpaRepository<EnderecoModels, Long> {
}
