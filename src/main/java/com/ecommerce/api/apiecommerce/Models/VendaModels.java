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

    @Column(name = "paypal_order_id")
    private String paypalOrderId;
    @Column(name = "paypal_order_status")
    private String paypalOrderStatus;
//
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "pedido_numero_pedido", referencedColumnName = "numeroPedido")
//    private PedidoModels pedido;



    public VendaModels(long id_venda, String codigoRastreio, PedidoModels pedido) {
        this.id_venda = id_venda;
        this.codigoRastreio = codigoRastreio;
//        this.pedido = pedido;
    }

    public VendaModels() {
    }

    public long getId_venda() {
        return id_venda;
    }

    public void setId_venda(long id_venda) {
        this.id_venda = id_venda;
    }

//    public PedidoModels getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(PedidoModels pedido) {
//        this.pedido = pedido;
//    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public String getPaypalOrderId() {
        return paypalOrderId;
    }

    public void setPaypalOrderId(String paypalOrderId) {
        this.paypalOrderId = paypalOrderId;
    }

    public String getPaypalOrderStatus() {
        return paypalOrderStatus;
    }

    public void setPaypalOrderStatus(String paypalOrderStatus) {
        this.paypalOrderStatus = paypalOrderStatus;
    }

    @Override
    public String toString() {
        return "VendaModels{" +
                "id_venda=" + id_venda +
                ", codigoRastreio='" + codigoRastreio + '\'' +
                ", paypalOrderId='" + paypalOrderId + '\'' +
                ", paypalOrderStatus='" + paypalOrderStatus + '\'' +
//                ", pedido=" + pedido +
                '}';
    }
}
