package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.CityModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepositories extends JpaRepository<CityModels, Long> {

}
