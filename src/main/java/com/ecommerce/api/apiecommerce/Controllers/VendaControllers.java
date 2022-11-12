package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Models.UserModels;
import com.ecommerce.api.apiecommerce.Models.VendaModels;
import com.ecommerce.api.apiecommerce.Services.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/venda")

public class VendaControllers {
    final VendaService vendaService;

    public VendaControllers(VendaService vendaService) {
        this.vendaService = vendaService;
    }
    @PostMapping
    public ResponseEntity <Object> saveVendas(@RequestBody UserModels user){
         System.err.println(user.toString());
         return ResponseEntity.status(HttpStatus.CREATED).
                body(vendaService.save(new VendaModels(0,user)));
    }


}
