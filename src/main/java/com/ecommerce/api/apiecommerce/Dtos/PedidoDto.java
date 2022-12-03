package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.ClienteModels;
import com.ecommerce.api.apiecommerce.Models.EnderecoModels;
import com.ecommerce.api.apiecommerce.PaypalSandBox.OrderIntent;
import com.ecommerce.api.apiecommerce.PaypalSandBox.PayPalAppContextDTO;
import com.ecommerce.api.apiecommerce.PaypalSandBox.PurchaseUnit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@Data
public class PedidoDto {


    @NotNull
    private Date data_pedido;
    @NotNull
    private Float valor;
    @NotNull
    private String paypal_order_status;
    @NotNull
    private Float valor_total;
    @NotNull
    private Float valor_frete;
    @NotNull
    private Date data_entrega;
    @NotNull
    private Float peso_pedido;
    @Nullable
    private String nomeRecebedor;
    @NotNull
    private EnderecoModels endereco;
    @NotNull
    private ClienteModels cliente;
    private OrderIntent intent;
    @JsonProperty("purchase_units")
    private List<PurchaseUnit> purchaseUnits;
    @JsonProperty("application_context")
    private PayPalAppContextDTO applicationContext;


    public PedidoDto(Date data_pedido,
                     Float valor,
                     String paypal_order_status,
                     Float valor_total,
                     Float valor_frete,
                     Date data_entrega,
                     Float peso_pedido,
                     @Nullable String nomeRecebedor,
                     EnderecoModels endereco,
                     ClienteModels cliente,
                     OrderIntent intent,
                     List<PurchaseUnit> purchaseUnits,
                     PayPalAppContextDTO applicationContext) {
        this.data_pedido = data_pedido;
        this.valor = valor;
        this.paypal_order_status = paypal_order_status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.peso_pedido = peso_pedido;
        this.nomeRecebedor = nomeRecebedor;
        this.endereco = endereco;
        this.cliente = cliente;
        this.intent = intent;
        this.purchaseUnits = purchaseUnits;
        this.applicationContext = applicationContext;
    }

    public PedidoDto(Date data_pedido, Float valor, String paypal_order_status, Float valor_total, Float valor_frete, Date data_entrega, Float peso_pedido, String nomeRecebedor, EnderecoModels endereco, ClienteModels cliente) {
        this.data_pedido = data_pedido;
        this.valor = valor;
        this.paypal_order_status = paypal_order_status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.peso_pedido = peso_pedido;
        this.nomeRecebedor = nomeRecebedor;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public PedidoDto(Date data_pedido, Float valor, String paypal_order_status, Float valor_total, Float valor_frete, Date data_entrega, Float peso_pedido, EnderecoModels endereco, ClienteModels cliente) {
        this.data_pedido = data_pedido;
        this.valor = valor;
        this.paypal_order_status = paypal_order_status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete; //sem recebedor
        this.data_entrega = data_entrega;
        this.peso_pedido = peso_pedido;
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
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

    public Float getPeso_pedido() {
        return peso_pedido;
    }

    public void setPeso_pedido(Float peso_pedido) {
        this.peso_pedido = peso_pedido;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
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
                ", valor=" + valor +
                ", paypal_order_status='" + paypal_order_status + '\'' +
                ", valor_total=" + valor_total +
                ", valor_frete=" + valor_frete +
                ", data_entrega=" + data_entrega +
                ", peso_pedido=" + peso_pedido +
                ", nomeRecebedor='" + nomeRecebedor + '\'' +
                ", endereco=" + endereco +
                ", cliente=" + cliente +
                ", intent=" + intent +
                ", purchaseUnits=" + purchaseUnits +
                ", applicationContext=" + applicationContext +
                '}';
    }
}
