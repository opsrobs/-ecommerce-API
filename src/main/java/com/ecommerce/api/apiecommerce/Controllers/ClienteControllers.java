package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.CityDto;
import com.ecommerce.api.apiecommerce.Dtos.ClienteDto;
import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.ClienteModels;
import com.ecommerce.api.apiecommerce.Models.EnderecoModels;
import com.ecommerce.api.apiecommerce.Services.ClienteServices;
import com.ecommerce.api.apiecommerce.Services.ServiceUtils;
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
@RequestMapping("/api/user-cliente")
public class ClienteControllers {
    private ServiceUtils utils = new ServiceUtils();
    final ClienteServices clienteServices;

    public ClienteControllers(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveClienteUser(@RequestBody @Valid ClienteDto clienteDto){
        var clienteModels = new ClienteModels();
        BeanUtils.copyProperties(clienteDto,clienteModels);
        System.err.println(clienteModels.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteServices.save(clienteModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientes(@PathVariable(value = "id") long id){
        Optional<ClienteModels> clienteModels = clienteServices.findById(id);
        if (!clienteModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found");
        }
        System.err.println(clienteModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(clienteModels.get());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<ClienteModels>> getAllAddress(@PageableDefault(
            page = 0,size = 10,sort = "idCliente",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServices.findAll(pageable));
    }
}
