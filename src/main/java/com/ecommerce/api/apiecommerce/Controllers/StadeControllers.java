package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.StadeDto;
import com.ecommerce.api.apiecommerce.Models.StadeModels;
import com.ecommerce.api.apiecommerce.Models.UserContatoModels;
import com.ecommerce.api.apiecommerce.Services.ServiceUtils;
import com.ecommerce.api.apiecommerce.Services.StadeServices;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONString;
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
@RequestMapping("/api/user-address-stade")
public class StadeControllers {

    private ServiceUtils utils = new ServiceUtils();
    final StadeServices stadeServices;

    public StadeControllers(StadeServices stadeServices) {
        this.stadeServices = stadeServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveStadeUser(@RequestBody @Valid StadeDto stadeDto){
        var stadeModels = new StadeModels();
        BeanUtils.copyProperties(stadeDto,stadeModels);
        System.err.println(stadeModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(stadeServices.save(stadeModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStades(@PathVariable(value = "id") long id){
        Optional<StadeModels> stadeModels = stadeServices.findById(id);
        if (!stadeModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stade not found");
        }
        System.err.println(stadeModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(stadeModels.get());
    }

    @GetMapping
    public ResponseEntity<Page<StadeModels>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(stadeServices.findAll(pageable));
    }
}
