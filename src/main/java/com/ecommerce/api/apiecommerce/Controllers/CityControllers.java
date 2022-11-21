package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.CityDto;
import com.ecommerce.api.apiecommerce.Dtos.StadeDto;
import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.StadeModels;
import com.ecommerce.api.apiecommerce.Services.CityServices;
import com.ecommerce.api.apiecommerce.Services.ServiceUtils;
import com.ecommerce.api.apiecommerce.Services.StadeServices;
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
@RequestMapping("/api/user-address-city")
public class CityControllers {
    private ServiceUtils utils = new ServiceUtils();

    final CityServices cityServices;

    public CityControllers(CityServices cityServices) {
        this.cityServices = cityServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveCityUser(@RequestBody @Valid CityDto cityDto){
        var cityModels = new CityModels();
        BeanUtils.copyProperties(cityDto,cityModels);
        System.err.println(cityModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cityServices.save(cityModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCitys(@PathVariable(value = "id") long id){
        Optional<CityModels> cityModels = cityServices.findById(id);
        if (!cityModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found");
        }
        System.err.println(cityModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(cityModels.get());
    }
}
