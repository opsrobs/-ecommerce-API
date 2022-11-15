package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.StadeModels;
import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Models.UserModels;
import com.ecommerce.api.apiecommerce.Repositories.StadeRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StadeServices {

    final StadeRepositories stadeRepositories;

    public StadeServices(StadeRepositories stadeRepositories) {
        this.stadeRepositories = stadeRepositories;
    }

    @Transactional
    public StadeModels save(StadeModels stadeModels){
        return stadeRepositories.save(stadeModels);
    }

    public Optional<StadeModels> findById(long id) {
        return stadeRepositories.findById(id);
    }

    public Page<StadeModels> findAll(Pageable pageable) {
        return stadeRepositories.findAll(pageable);
    }
}
