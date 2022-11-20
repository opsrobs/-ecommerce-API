package com.ecommerce.api.apiecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")
public class EnderecoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEndereco;
    @JsonIgnore
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private BairroModels bairro;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private long numero;
    @Column(nullable = false)
    private Boolean ativo;



    public EnderecoModels(long idEndereco, String cep, String rua, String complemento, long numero, Boolean ativo, BairroModels bairro) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
        this.ativo = ativo;
        this.bairro = bairro;
    }

    public EnderecoModels() {
    }

    public long getidEndereco() {
        return idEndereco;
    }

    public void setidEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public BairroModels getBairro() {
        return bairro;
    }

    public void setBairro(BairroModels bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "EnderecoModels{" +
                "idEndereco=" + idEndereco +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numero=" + numero +
                ", ativo=" + ativo +
                ", bairro=" + bairro +
                '}';
    }
}
