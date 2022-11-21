package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.UserContatoDto;
import com.ecommerce.api.apiecommerce.Dtos.PessoaDto;
import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.ecommerce.api.apiecommerce.Services.UserService;
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
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/e-commerce")
public class UserControllers {

    final UserService userService;

    public UserControllers(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/new-user")
    public ResponseEntity<Object> saveUsers(@RequestBody @Valid PessoaDto PessoaDto){
        if (userService.existsByUserName(PessoaDto.getUserName())){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: This username already been created!");
        }
        var PessoaModels = new PessoaModels();
        BeanUtils.copyProperties(PessoaDto,PessoaModels);
        System.err.println(PessoaDto +"\n" + PessoaModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(PessoaModels));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<PessoaModels>> getAllUsers(@PageableDefault(
            page = 0,size = 10,sort = "userID",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "id") long id){
        Optional<PessoaModels> PessoaModelsOptional = userService.findById(id);
        if (!PessoaModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("username not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(PessoaModelsOptional.get());
    }

    @PutMapping("/{idd}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid PessoaDto PessoaDto){
        Optional<PessoaModels> PessoaModelsOptional = userService.findById(id);
        if (!PessoaModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
        }
        var PessoaModels = new PessoaModels();
        BeanUtils.copyProperties(PessoaDto, PessoaModels);

        PessoaModels.setUserID(PessoaModelsOptional.get().getUserID());
        PessoaModels.setUserName(PessoaDto.getUserName());
        PessoaModels.setNome(PessoaDto.getNome());
//        PessoaModels.set(PessoaDto.getLast_name());
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.save(PessoaModels));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContactUser(@PathVariable(value = "id") long id){
        Optional<PessoaModels> PessoaModelsOptional = userService.findById(id);
        if (!PessoaModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
        }
        var PessoaModels = new PessoaModels();
        PessoaModels.setUserID(PessoaModelsOptional.get().getUserID());
        PessoaModels.setNome(PessoaModelsOptional.get().getNome());
//        PessoaModels.setLast_name(PessoaModelsOptional.get().getLast_name());
        PessoaModels.setPassword(PessoaModelsOptional.get().getPassword());
        PessoaModels.setUserName(PessoaModelsOptional.get().getUserName());
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.save(PessoaModels));
    }
}
