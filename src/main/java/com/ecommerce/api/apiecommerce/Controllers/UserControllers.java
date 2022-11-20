package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.UserContatoDto;
import com.ecommerce.api.apiecommerce.Dtos.UserDto;
import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Models.UserModels;
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
    public ResponseEntity<Object> saveUsers(@RequestBody @Valid UserDto userDto){
        if (userService.existsByUserName(userDto.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: This username already been created!");
        }
        var userModels = new UserModels();
        BeanUtils.copyProperties(userDto,userModels);
        System.err.println(userDto +"\n" + userModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(userModels));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<UserModels>> getAllUsers(@PageableDefault(
            page = 0,size = 10,sort = "userID",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "id") long id){
        Optional<UserModels> userModelsOptional = userService.findById(id);
        if (!userModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("username not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelsOptional.get());
    }

    @PutMapping("/{idd}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid UserDto userDto){
        Optional<UserModels> userModelsOptional = userService.findById(id);
        if (!userModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
        }
        var userModels = new UserModels();
        BeanUtils.copyProperties(userDto, userModels);

        userModels.setUserID(userModelsOptional.get().getUserID());
        userModels.setUserName(userDto.getUserName());
        userModels.setFirst_name(userDto.getFirst_name());
        userModels.setLast_name(userDto.getLast_name());
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.save(userModels));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContactUser(@PathVariable(value = "id") long id){
        Optional<UserModels> userModelsOptional = userService.findById(id);
        if (!userModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
        }
        var userModels = new UserModels();
        userModels.setUserID(userModelsOptional.get().getUserID());
        userModels.setFirst_name(userModelsOptional.get().getFirst_name());
        userModels.setLast_name(userModelsOptional.get().getLast_name());
        userModels.setPassword(userModelsOptional.get().getPassword());
        userModels.setUserName(userModelsOptional.get().getUserName());
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.save(userModels));
    }
}
