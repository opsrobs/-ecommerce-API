package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.BairroDto;
import com.ecommerce.api.apiecommerce.Dtos.CityDto;
import com.ecommerce.api.apiecommerce.Models.BairroModels;
import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;
import com.ecommerce.api.apiecommerce.Services.BairroServices;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        System.err.println(bairroModels.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bairroServices.save(bairroModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBairro(@PathVariable(value = "id") long id){
        Optional<BairroModels> optionalBairroModels = bairroServices.findById(id);
        if (!optionalBairroModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bairro not found");
        }
        System.err.println(optionalBairroModels.get().getEndereco());
        return ResponseEntity.status(HttpStatus.OK).body(optionalBairroModels.get());
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<BairroModels>> getAllCategories(@PageableDefault(
            page = 0,size = 10,sort = "idBairro",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(bairroServices.findAll(pageable));
    }
}
