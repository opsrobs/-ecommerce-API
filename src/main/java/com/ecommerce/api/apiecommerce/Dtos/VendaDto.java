package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.PedidoModels;
import com.ecommerce.api.apiecommerce.PaypalSandBox.OrderIntent;
import com.ecommerce.api.apiecommerce.PaypalSandBox.PayPalAppContextDTO;
import com.ecommerce.api.apiecommerce.PaypalSandBox.PurchaseUnit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class VendaDto {
    @Nullable
    private String codigoRastreio;
    @NotNull
    private PedidoModels pedido;
    @NotNull
    private String paypal_order_status;

    private OrderIntent intent;
    @JsonProperty("purchase_units")
    private List<PurchaseUnit> purchaseUnits;
    @JsonProperty("application_context")
    private PayPalAppContextDTO applicationContext;

    public VendaDto(@Nullable String codigoRastreio, PedidoModels pedido) {
        this.codigoRastreio = codigoRastreio;
        this.pedido = pedido;
    }

    public VendaDto(PedidoModels pedido) {
        this.pedido = pedido;
    }

    public VendaDto() {
    }

    @Nullable
    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(@Nullable String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public PedidoModels getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModels pedido) {
        this.pedido = pedido;
    }

    public String getPaypal_order_status() {
        return paypal_order_status;
    }

    public void setPaypal_order_status(String paypal_order_status) {
        this.paypal_order_status = paypal_order_status;
    }

    public OrderIntent getIntent() {
        return intent;
    }

    public void setIntent(OrderIntent intent) {
        this.intent = intent;
    }

    public List<PurchaseUnit> getPurchaseUnits() {
        return purchaseUnits;
    }

    public void setPurchaseUnits(List<PurchaseUnit> purchaseUnits) {
        this.purchaseUnits = purchaseUnits;
    }

    public PayPalAppContextDTO getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(PayPalAppContextDTO applicationContext) {
        this.applicationContext = applicationContext;
    }
}
