package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;

@Entity
@Table(name = "venda")
public class VendaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_venda;
    @Column(nullable = true)
    private String codigoRastreio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_numero_pedido", referencedColumnName = "numeroPedido")
    private PedidoModels pedido;

    public VendaModels(long id_venda, PedidoModels pedido) {
        this.id_venda = id_venda;
        this.pedido = pedido;
    }

    public VendaModels(long id_venda, String codigoRastreio, PedidoModels pedido) {
        this.id_venda = id_venda;
        this.codigoRastreio = codigoRastreio;
        this.pedido = pedido;
    }

    public VendaModels() {
    }

    public long getId_venda() {
        return id_venda;
    }

    public void setId_venda(long id_venda) {
        this.id_venda = id_venda;
    }

    public PedidoModels getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModels pedido) {
        this.pedido = pedido;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }
}
