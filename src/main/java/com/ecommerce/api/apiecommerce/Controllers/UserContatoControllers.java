package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.UserContatoDto;
import com.ecommerce.api.apiecommerce.Dtos.UserDto;
import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Services.ServiceUtils;
import com.ecommerce.api.apiecommerce.Services.UserContatoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user-contato")
public class UserContatoControllers {

    private ServiceUtils serviceUtils = new ServiceUtils();
    private UserDto userDto = new UserDto();
    final UserControllers userControllers;
    final UserContatoServices userContatoServices;

    public UserContatoControllers(UserControllers userControllers, UserContatoServices userContatoServices) {
        this.userControllers = userControllers;
        this.userContatoServices = userContatoServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveUserContact(@RequestBody @Valid UserContatoDto userContatoDto){
        var userContatoModels = new UserContatoModels();
        BeanUtils.copyProperties(userContatoDto,userContatoModels);
        System.err.println(userContatoDto +"\n" + userContatoModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userContatoServices.save(userContatoModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllSales(@PathVariable(value = "id") long id){
        Optional<UserContatoModels> userContatoModels = userContatoServices.findById(id);
        if (!userContatoModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
        }
        System.err.println(userContatoModels.get());
        return ResponseEntity.status(HttpStatus.OK).body(userContatoModels.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContactUser(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid UserContatoDto userContatoDto){
        Optional<UserContatoModels> optionalUserContatoModels = userContatoServices.findById(id);
        if (!optionalUserContatoModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
        }
        var userContatoModels = new UserContatoModels();
        BeanUtils.copyProperties(userContatoDto, userContatoModels);
        System.err.println(userContatoModels.getUser().getUserID());
        userControllers.updateContactUser(userContatoDto.getUser().getUserID());

        userContatoModels.setId_contato(optionalUserContatoModels.get().getId_contato());
        userContatoModels.setDate_created(new Date());
        userContatoModels.setTelefone(userContatoDto.getTelefone());

        return ResponseEntity.status(HttpStatus.OK).body(
                userContatoServices.save(userContatoModels));
    }


}
