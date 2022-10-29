package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
<<<<<<< HEAD
public interface UserRepositories extends JpaRepository<UserModels, Long> {
    boolean existsByUserName(String username);

    Optional<UserModels> findByUserName(String username);

=======
public interface UserRepositories extends JpaRepository<UserModels, UUID> {

    boolean existsByUserName(String username);

    Optional<UserModels> findByUserName(String username);
>>>>>>> fcad320233646e75ca809b55f58f58c4dc2bd2d1

}
