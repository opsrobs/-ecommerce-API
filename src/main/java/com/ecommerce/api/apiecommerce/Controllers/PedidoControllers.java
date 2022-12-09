package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.PedidoDto;
import com.ecommerce.api.apiecommerce.Models.PedidoModels;
import com.ecommerce.api.apiecommerce.Services.PedidoServices;
import com.ecommerce.api.apiecommerce.Services.ServiceUtils;
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
@RequestMapping("/api/user-pedido")
public class PedidoControllers {
    private ServiceUtils utils = new ServiceUtils();
    final PedidoServices pedidoServices;

    public PedidoControllers(PedidoServices pedidoServices) { this.pedidoServices = pedidoServices; }

    @PostMapping
    public ResponseEntity<Object> savePedidoUser(@RequestBody @Valid PedidoDto pedidoDto){
        var pedidoModels = new PedidoModels();
        BeanUtils.copyProperties(pedidoDto,pedidoModels);
        System.err.println(pedidoModels.toString()+ "  /n  "+ pedidoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoServices.save(pedidoModels));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPedido(@PathVariable(value = "id") long id){
        Optional<PedidoModels> pedidoModels = pedidoServices.findById(id);
        if (!pedidoModels.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido not found");
        }
        System.err.println(pedidoModels.toString());
        return ResponseEntity.status(HttpStatus.OK).body(pedidoModels.get());
    }

    @GetMapping
    public ResponseEntity<Page<PedidoModels>> getAllPedido(@PageableDefault(page = 0, size = 10, sort = "numeroPedido", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServices.findAll(pageable));
    }

    @PutMapping("/pedido/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") long id,
                                             @RequestBody @Valid PedidoDto pedidoDto){
        Optional<PedidoModels> pedidoModelsOptional = pedidoServices.findById(id);
        if (!pedidoModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
        }
        var pedido = new PedidoModels();
        BeanUtils.copyProperties(pedidoDto, pedido);

        pedido.setCliente(pedidoDto.getCliente());
        pedido.setValor_total(pedidoDto.getValor_total());
        return ResponseEntity.status(HttpStatus.OK).body(
                pedidoServices.save(pedido));
    }

}
