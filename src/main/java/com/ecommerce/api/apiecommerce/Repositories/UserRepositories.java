package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserModels, Long> {
    boolean existsByUserName(String username);
}
