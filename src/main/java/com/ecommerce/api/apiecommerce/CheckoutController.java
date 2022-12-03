package com.ecommerce.api.apiecommerce;
import com.ecommerce.api.apiecommerce.Dtos.PedidoDto;
import com.ecommerce.api.apiecommerce.Dtos.VendaDto;
import com.ecommerce.api.apiecommerce.Models.PedidoModels;
import com.ecommerce.api.apiecommerce.Models.VendaModels;
import com.ecommerce.api.apiecommerce.PaypalSandBox.*;
import com.ecommerce.api.apiecommerce.Repositories.PedidoRepositories;
import com.ecommerce.api.apiecommerce.Repositories.VendaRepositories;
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
    private final VendaRepositories vendaRepositories;

    @Autowired
    public CheckoutController(PayPalHttpClient payPalHttpClient, VendaRepositories vendaRepositories) {
        this.payPalHttpClient = payPalHttpClient;
        this.vendaRepositories = vendaRepositories;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> checkout(@RequestBody VendaDto vendaDto) throws Exception {
//        var orderDTO = new OrderDTO();
        AccessTokenResponseDTO token = new AccessTokenResponseDTO();
        var appContext = new PayPalAppContextDTO();
        appContext.setReturnUrl("http://localhost:8080/checkout/success");
        appContext.setBrandName("My brand");
        appContext.setLandingPage(PaymentLandingPage.BILLING);
        vendaDto.setApplicationContext(appContext);
//        System.err.println(pedidoDto);
        var orderResponse = payPalHttpClient.createOrder(vendaDto);
        System.err.println(vendaDto.toString());
        var entity = new VendaModels();
        entity.setPaypalOrderId(orderResponse.getId());
        entity.setPaypalOrderStatus(orderResponse.getStatus().toString());
        BeanUtils.copyProperties(vendaDto,entity); //se salva tá errado
        System.err.println(entity);
        var out = vendaRepositories.save(entity);
        log.info("Saved order: {}", out.toString());
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping(value = "/success")
    public ResponseEntity<String> paymentSuccess(HttpServletRequest request) {
        var orderId = request.getParameter("token");
        System.err.println(request.getParameter("token"));
        var out = vendaRepositories.findByPaypalOrderId(orderId);
        out.setPaypalOrderStatus(OrderStatus.APPROVED.toString());
        vendaRepositories.save(out);
        return ResponseEntity.ok().body("Payment success");
    }

}
