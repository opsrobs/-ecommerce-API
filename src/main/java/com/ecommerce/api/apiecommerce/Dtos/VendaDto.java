package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.PedidoModels;

import javax.validation.constraints.NotNull;

public class VendaDto {
    @NotNull
    private String nomeRecebedor;
    @NotNull
    private PedidoModels pedido;

    public VendaDto(String nomeRecebedor, PedidoModels pedido) {
        this.nomeRecebedor = nomeRecebedor;
        this.pedido = pedido;
    }

    public VendaDto() {
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }

    public PedidoModels getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModels pedido) {
        this.pedido = pedido;
    }
}
