package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.UserContatoDto;
import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Models.UserModels;
import com.ecommerce.api.apiecommerce.Services.UserContatoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user-contato")
public class UserContatoControllers {
    final UserContatoServices userContatoServices;

    public UserContatoControllers(UserContatoServices userContatoServices) {
        this.userContatoServices = userContatoServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveUserContact(@RequestBody @Valid UserContatoDto userContatoDto){
        var userContatoModels = new UserContatoModels();
        BeanUtils.copyProperties(userContatoDto,userContatoModels);
        System.err.println(userContatoDto +"\n" + userContatoModels);
        return ResponseEntity.status(HttpStatus.OK).body(userContatoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") long id){
        Optional<UserContatoModels> userContatoModels = userContatoServices.findById(id);
        if (!userContatoModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
        }
        System.err.println(userContatoModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(userContatoModels.get());
    }


}
