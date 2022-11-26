package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.ProductDto;
import com.ecommerce.api.apiecommerce.Models.ProductModels;
import com.ecommerce.api.apiecommerce.Services.ProductServices;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user-products")
public class ProductControllers {

    private static String caminhoImagens = "C:\\projetos\\ecommerce\\imagens";
    final ProductServices productServices;

    public ProductControllers(ProductServices productServices) {
        this.productServices = productServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveProducts(@RequestBody @Valid ProductDto productDto){
        if (productServices.existsByNomeTipo(productDto.getNomeProduto())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: This product already been created!");
        }

        var productModels = new ProductModels();
        BeanUtils.copyProperties(productDto,productModels);
        System.err.println(productDto +"\n" + productModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productServices.save(productModels));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<ProductModels>> getAllProducts(@PageableDefault(
            page = 0,size = 10,sort = "id",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(productServices.findAll(pageable));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value = "id") long id){
        Optional<ProductModels> productModels = productServices.findByid(id);
        return productModels.<ResponseEntity<Object>>map(typeModels -> ResponseEntity.status(HttpStatus.OK).body(typeModels)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("username not found"));
    }


}
