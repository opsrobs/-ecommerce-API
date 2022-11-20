package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.BairroDto;
import com.ecommerce.api.apiecommerce.Dtos.CityDto;
import com.ecommerce.api.apiecommerce.Models.BairroModels;
import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Services.BairroServices;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user-address-bairro")
public class BairroControllers {

    final BairroServices bairroServices;

    public BairroControllers(BairroServices bairroServices) {
        this.bairroServices = bairroServices;
    }

    @PostMapping
    public ResponseEntity<Object> SaveBairro(@RequestBody @Valid BairroDto bairroDto){
        var bairroModels = new BairroModels();
        BeanUtils.copyProperties(bairroDto,bairroModels);
        System.err.println(bairroModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bairroServices.save(bairroModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBairro(@PathVariable(value = "id") long id){
        Optional<BairroModels> optionalBairroModels = bairroServices.findById(id);
        if (!optionalBairroModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro not found");
        }
        System.err.println(optionalBairroModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(optionalBairroModels.get());
    }
}
