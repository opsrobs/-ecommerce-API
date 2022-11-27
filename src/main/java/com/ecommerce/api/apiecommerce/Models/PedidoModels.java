package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Pedido")
public class PedidoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroPedido;
    @Column(nullable = false)
    private Date data_pedido;
    @Column(nullable = false)
    private Float valor;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Float valor_total;
    @Column(nullable = false)
    private Float valor_frete;
    @Column(nullable = true)
    private Date data_entrega;
    @Column(nullable = false)
    private Float peso_pedido;
    @Column(nullable = true)
    private String nomeRecebedor;       //talvez seja interessante remover

    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private EnderecoModels endereco;

    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private ClienteModels cliente;


    public PedidoModels(long numeroPedido, Date data_pedido, Float valor, String status, Float valor_total, Float valor_frete, Date data_entrega, Float peso_pedido, String nomeRecebedor, EnderecoModels endereco, ClienteModels cliente) {
        this.numeroPedido = numeroPedido;
        this.data_pedido = data_pedido;
        this.valor = valor;
        this.status = status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.peso_pedido = peso_pedido;
        this.nomeRecebedor = nomeRecebedor;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public PedidoModels(long numeroPedido, Date data_pedido, Float valor, String status, Float valor_total, Float valor_frete, Date data_entrega, Float peso_pedido, EnderecoModels endereco, ClienteModels cliente) {
        this.numeroPedido = numeroPedido;
        this.data_pedido = data_pedido;
        this.valor = valor;         //sem recebedor
        this.status = status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.peso_pedido = peso_pedido;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public PedidoModels() {
    }

    public long getnumeroPedido() {
        return numeroPedido;
    }

    public void setnumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
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
}
