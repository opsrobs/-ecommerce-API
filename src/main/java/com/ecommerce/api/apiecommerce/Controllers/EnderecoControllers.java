package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.BairroDto;
import com.ecommerce.api.apiecommerce.Dtos.EnderecoDto;
import com.ecommerce.api.apiecommerce.Models.BairroModels;
import com.ecommerce.api.apiecommerce.Models.EnderecoModels;
import com.ecommerce.api.apiecommerce.Services.EnderecoServices;
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
@RequestMapping("/api/user-address-endereco")
public class EnderecoControllers {
    final EnderecoServices enderecoServices;

    public EnderecoControllers(EnderecoServices enderecoServices) {
        this.enderecoServices = enderecoServices;
    }

    @PostMapping
    public ResponseEntity<Object> SaveEndereco(@RequestBody @Valid EnderecoDto enderecoDto){
        var enderecoModels = new EnderecoModels();
        BeanUtils.copyProperties(enderecoDto,enderecoModels);
        System.err.println(enderecoModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(enderecoServices.save(enderecoModels));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEndereco(@PathVariable(value = "id") long id){
        Optional<EnderecoModels> optionalEnderecoModels = enderecoServices.findById(id);
        if (!optionalEnderecoModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco not found");
        }
        System.err.println(optionalEnderecoModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(optionalEnderecoModels.get());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<EnderecoModels>> getAllAddress(@PageableDefault(
            page = 0,size = 10,sort = "idEndereco",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoServices.findAll(pageable));
    }
}
