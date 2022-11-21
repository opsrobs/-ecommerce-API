package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositories extends JpaRepository<PessoaModels, Long> {
    boolean existsByUserName(String username);

    Optional<PessoaModels> findByUserName(String username);


}
