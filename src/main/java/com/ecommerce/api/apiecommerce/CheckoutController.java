package com.ecommerce.api.apiecommerce;
import com.ecommerce.api.apiecommerce.Dtos.PedidoDto;
import com.ecommerce.api.apiecommerce.Models.PedidoModels;
import com.ecommerce.api.apiecommerce.PaypalSandBox.*;
import com.ecommerce.api.apiecommerce.Repositories.PedidoRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/checkout")
@Slf4j
public class CheckoutController {

    private final PayPalHttpClient payPalHttpClient;
    private final PedidoRepositories pedidoRepositories;

    @Autowired
    public CheckoutController(PayPalHttpClient payPalHttpClient, PedidoRepositories pedidoRepositories) {
        this.payPalHttpClient = payPalHttpClient;
        this.pedidoRepositories = pedidoRepositories;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> checkout(@RequestBody PedidoDto pedidoDto) throws Exception {
//        var orderDTO = new OrderDTO();
        var appContext = new PayPalAppContextDTO();
        appContext.setReturnUrl("http://localhost:8080/checkout/success");
        appContext.setBrandName("My brand");
        appContext.setLandingPage(PaymentLandingPage.BILLING);
        pedidoDto.setApplicationContext(appContext);
//        System.err.println(pedidoDto);
        var orderResponse = payPalHttpClient.createOrder(pedidoDto);
        System.err.println(pedidoDto.toString());
        var entity = new PedidoModels();
        entity.setPaypalOrderId(orderResponse.getId());
        entity.setPaypalOrderStatus(orderResponse.getStatus().toString());
        BeanUtils.copyProperties(pedidoDto,entity); //se salva tá errado
        System.err.println(entity);
        var out = pedidoRepositories.save(entity);
        log.info("Saved order: {}", out);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping(value = "/success")
    public ResponseEntity<String> paymentSuccess(HttpServletRequest request) {
        var orderId = request.getParameter("token");
        var out = pedidoRepositories.findByPaypalOrderId(orderId);
        out.setPaypalOrderStatus(OrderStatus.APPROVED.toString());
        pedidoRepositories.save(out);
        return ResponseEntity.ok().body("Payment success");
    }

}
