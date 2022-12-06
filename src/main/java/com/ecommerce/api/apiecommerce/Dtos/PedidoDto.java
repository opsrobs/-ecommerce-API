package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.ClienteModels;
import com.ecommerce.api.apiecommerce.Models.EnderecoModels;
import com.ecommerce.api.apiecommerce.Models.ProductModels;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class PedidoDto {
    @NotNull
    private Date data_pedido;
    @NotNull
    private String status;
    @NotNull
    private Float valor_total;
    @NotNull
    private Float valor_frete;

    private Date data_entrega;

    @NotNull
    private List<ProductModels> produto;
    @NotNull
    private EnderecoModels endereco;
    @NotNull
    private ClienteModels cliente;

    public PedidoDto(Date data_pedido, Float valor, String status, Float valor_total, Float valor_frete, Date data_entrega, EnderecoModels endereco, ClienteModels cliente) {
        this.data_pedido = data_pedido;
        this.status = status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public PedidoDto(Date data_pedido, String status, Float valor_total, Float valor_frete, Date data_entrega, List<ProductModels> produto, EnderecoModels endereco, ClienteModels cliente) {
        this.data_pedido = data_pedido;
        this.status = status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.produto = produto;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public PedidoDto(Date data_pedido, String status, Float valor_total, Float valor_frete, Date data_entrega, EnderecoModels endereco, ClienteModels cliente) {
        this.data_pedido = data_pedido;
        this.status = status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete; //sem recebedor
        this.data_entrega = data_entrega;
        this.endereco = endereco;
        this.cliente = cliente;
    }


    public PedidoDto() {
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getValor_total() {
        return valor_total;
    }

    public void setValor_total(Float valor_total) {
        this.valor_total = valor_total;
    }

    public Float getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(Float valor_frete) {
        this.valor_frete = valor_frete;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public List<ProductModels> getProduto() {
        return produto;
    }

    public void setProdutos(List<ProductModels> produto) {
        this.produto = produto;
    }

    public EnderecoModels getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModels endereco) {
        this.endereco = endereco;
    }

    public ClienteModels getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModels cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "PedidoDto{" +
                "data_pedido=" + data_pedido +
                ", status='" + status + '\'' +
                ", valor_total=" + valor_total +
                ", valor_frete=" + valor_frete +
                ", data_entrega=" + data_entrega +
                ", produto=" + produto +
                ", endereco=" + endereco +
                ", cliente=" + cliente +
                '}';
    }
}