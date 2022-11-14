package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;

@Entity
@Table(name = "venda")
public class VendaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_venda;
    @Column
    private long id_pessoa;

    public VendaModels(long id_venda, long id_pessoa) {
        this.id_venda = id_venda;
        this.id_pessoa = id_pessoa;
    }

    public VendaModels(long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public VendaModels() {
    }

    public long getId_venda() {
        return id_venda;
    }

    public void setId_venda(long id_venda) {
        this.id_venda = id_venda;
    }

    public long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
}