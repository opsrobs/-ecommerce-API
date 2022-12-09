package com.ecommerce.api.apiecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name= "Cliente")
public class ClienteModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCliente;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "userID")
    private PessoaModels pessoa;

    public ClienteModels(long idCliente, PessoaModels pessoa) {
        this.idCliente = idCliente;
        this.pessoa = pessoa;
    }

    public ClienteModels() {
    }

    public long getidCliente() {
        return idCliente;
    }

    public void setidCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public PessoaModels getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModels pessoa) {
        this.pessoa = pessoa;
    }

//    @Override
//    public String toString() {
//        return "ClienteModels{" +
//                "idCliente=" + idCliente +
//                ", pessoa=" + pessoa +
//                '}';
//    }
}
