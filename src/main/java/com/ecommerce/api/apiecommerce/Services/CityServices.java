package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.StadeModels;
import com.ecommerce.api.apiecommerce.Repositories.CityRepositories;
import com.ecommerce.api.apiecommerce.Repositories.StadeRepositories;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CityServices {
    final CityRepositories cityRepositories;

    public CityServices(CityRepositories cityRepositories) {
        this.cityRepositories = cityRepositories;
    }

    @Transactional
    public CityModels save(CityModels cityModels){
        return cityRepositories.save(cityModels);
    }

    public Optional<CityModels> findById(long id) {
        return cityRepositories.findById(id);
    }
}
