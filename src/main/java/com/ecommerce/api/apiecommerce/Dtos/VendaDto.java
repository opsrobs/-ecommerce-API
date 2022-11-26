package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.PedidoModels;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class VendaDto {
    @Nullable
    private String codigoRastreio;
    @NotNull
    private PedidoModels pedido;

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
}
