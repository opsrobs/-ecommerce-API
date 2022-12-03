package com.ecommerce.api.apiecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name= "Cliente")
public class ClienteModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_cliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "pessoa_id", referencedColumnName = "userID")
    private PessoaModels pessoa;

    public ClienteModels(long id_cliente, PessoaModels pessoa) {
        this.id_cliente = id_cliente;
        this.pessoa = pessoa;
    }

    public ClienteModels() {
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public PessoaModels getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModels pessoa) {
        this.pessoa = pessoa;
    }
}
