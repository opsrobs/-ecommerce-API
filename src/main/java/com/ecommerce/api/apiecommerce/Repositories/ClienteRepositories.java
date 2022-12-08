package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.ClienteModels;
import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepositories extends JpaRepository<ClienteModels, Long> {

    @Query("select cl from ClienteModels cl where cl.pessoa.userID = :idpessoa")
    Optional<ClienteModels> findByPessoa(Long idpessoa);

}
