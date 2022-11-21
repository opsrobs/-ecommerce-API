package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.CityDto;
import com.ecommerce.api.apiecommerce.Dtos.VendaDto;
import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.UserModels;
import com.ecommerce.api.apiecommerce.Models.VendaModels;
import com.ecommerce.api.apiecommerce.Services.VendaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/venda")

public class VendaControllers {
    final VendaService vendaService;

    public VendaControllers(VendaService vendaService) {
        this.vendaService = vendaService;
    }
    @PostMapping
    public ResponseEntity<Object> saveVendaUser(@RequestBody @Valid VendaDto vendaDto){
        var vendaModels = new VendaModels();
        BeanUtils.copyProperties(vendaDto,vendaModels);
        System.err.println(vendaModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vendaService.save(vendaModels));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVendas(@PathVariable(value = "id") long id){
        Optional<VendaModels> vendaModels = vendaService.findById(id);
        if (!vendaModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda not found");
        }
        System.err.println(vendaModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(vendaModels.get());
    }


}
