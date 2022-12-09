package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "Pedido")
public class PedidoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroPedido;
    @Column(nullable = false)
    private Date data_pedido;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Float valor_total;
    @Column(nullable = false)
    private Float valor_frete;
    @Column(nullable = true)
    private Date data_entrega;

//    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER) // OneToMany associate aos contacts
//    @Fetch(FetchMode.SUBSELECT)
//    private List<ProductModels> produto;

    @ManyToMany
        @JoinTable(name = "TB_USER_PURCHASE",
            joinColumns = @JoinColumn(name= "numeroPedido"),
            inverseJoinColumns = @JoinColumn(name= "id"))
    private List<ProductModels> produto;
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private EnderecoModels endereco;

    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private ClienteModels cliente;


    public PedidoModels(long numeroPedido, Date data_pedido, String status, Float valor_total, Float valor_frete, Date data_entrega, EnderecoModels endereco, ClienteModels cliente) {
        this.numeroPedido = numeroPedido;
        this.data_pedido = data_pedido;
        this.status = status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public PedidoModels(long numeroPedido, Date data_pedido, String status, Float valor_total, Float valor_frete, Date data_entrega, List<ProductModels> produto, EnderecoModels endereco, ClienteModels cliente) {
        this.numeroPedido = numeroPedido;
        this.data_pedido = data_pedido;
        this.status = status;
        this.valor_total = valor_total;
        this.valor_frete = valor_frete;
        this.data_entrega = data_entrega;
        this.produto = produto;
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public PedidoModels() {
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

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<ProductModels> getProduto() {
        return produto;
    }

    public void setProduto(List<ProductModels> produto) {
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
        return "PedidoModels{" +
                "numeroPedido=" + numeroPedido +
                ", data_pedido=" + data_pedido +
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