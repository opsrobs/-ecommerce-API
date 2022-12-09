package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.UserEmailDto;
import com.ecommerce.api.apiecommerce.Models.UserEmailModels;
import com.ecommerce.api.apiecommerce.Services.UserEmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user-email")
public class UserEmailControllers {

    final UserEmailService userEmailService;

    public UserEmailControllers(UserEmailService userEmailService) {
        this.userEmailService = userEmailService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUserContact(@RequestBody @Valid UserEmailDto userEmailDto){
        var userEmailModels = new UserEmailModels();
        BeanUtils.copyProperties(userEmailDto,userEmailModels);
        userEmailModels.setDate_created(new Date());
        System.err.println(userEmailDto +"\n" + userEmailModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userEmailService.save(userEmailModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllSales(@PathVariable(value = "id") long id){
        Optional<UserEmailModels> userEmailModels = userEmailService.findById(id);
        if (!userEmailModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
        }
        System.err.println(userEmailModels.get());
        return ResponseEntity.status(HttpStatus.OK).body(userEmailModels.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContactUser(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid UserEmailDto userEmailDto){
        Optional<UserEmailModels> userEmailModelsOptional = userEmailService.findById(id);
        if (!userEmailModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
        }
        var userEmailModels = new UserEmailModels();
        BeanUtils.copyProperties(userEmailDto, userEmailModels);
        userEmailModels.setidEmail(userEmailModelsOptional.get().getidEmail());
        userEmailModels.setDate_created(new Date());
        userEmailModels.setEmail(userEmailModelsOptional.get().getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(
                userEmailService.save(userEmailModelsOptional.get()));
    }

    @GetMapping
    public ResponseEntity<Page<UserEmailModels>> getAllUsers(@PageableDefault(
            page = 0,size = 10,sort = "idEmail",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userEmailService.findAll(pageable));
    }


}
