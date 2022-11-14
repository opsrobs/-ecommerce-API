package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Models.UserModels;
import com.ecommerce.api.apiecommerce.Models.VendaModels;
import com.ecommerce.api.apiecommerce.Repositories.UserContatoRepositorie;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserContatoServices {
    final UserContatoRepositorie userContatoRepositorie;

    public UserContatoServices(UserContatoRepositorie userContatoRepositorie) {
        this.userContatoRepositorie = userContatoRepositorie;
    }

    @Transactional
    public UserContatoModels save(UserContatoModels userContatoModels){
        return userContatoRepositorie.save(userContatoModels);
    }

    public Optional<UserContatoModels> findById (long id){
        System.err.println("\n\nDebug");
        return userContatoRepositorie.findById(id);
    }
}
