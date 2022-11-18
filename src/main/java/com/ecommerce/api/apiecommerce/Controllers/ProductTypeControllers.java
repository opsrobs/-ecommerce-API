package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.ProductTypeDto;
import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;
import com.ecommerce.api.apiecommerce.Services.PorductTypeServices;
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
@RequestMapping("/api/user-categories")
public class ProductTypeControllers {
    final PorductTypeServices porductTypeServices;

    public ProductTypeControllers(PorductTypeServices porductTypeServices) {
        this.porductTypeServices = porductTypeServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveCategories(@RequestBody @Valid ProductTypeDto productTypeDto){
        if (porductTypeServices.existsByNomeTipo(productTypeDto.getNomeTipo())){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: This username already been created!");
        }
        var productTypeModels = new ProductTypeModels();
        BeanUtils.copyProperties(productTypeDto,productTypeModels);
        System.err.println(productTypeDto +"\n" + productTypeModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(porductTypeServices.save(productTypeModels));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<ProductTypeModels>> getAllCategories(@PageableDefault(
            page = 0,size = 10,sort = "id",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(porductTypeServices.findAll(pageable));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategorieById(@PathVariable(value = "id") long id){
        Optional<ProductTypeModels> productTypeModels = porductTypeServices.findById(id);
        return productTypeModels.<ResponseEntity<Object>>map(typeModels -> ResponseEntity.status(HttpStatus.OK).body(typeModels)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("username not found"));
    }


}
