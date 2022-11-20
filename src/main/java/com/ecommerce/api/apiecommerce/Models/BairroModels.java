package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Bairro")
public class BairroModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBairro;
    @Column(nullable = false)
    private String nomeBairro;
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private CityModels city;

    //_________________//
    @OneToMany(mappedBy = "bairro", fetch = FetchType.EAGER) // OneToMany associate aos Emails
    @Fetch(FetchMode.SUBSELECT)
    private List<EnderecoModels> endereco;

    public BairroModels(long idBairro, String nomeBairro, CityModels city) {
        this.idBairro = idBairro;
        this.nomeBairro = nomeBairro;
        this.city = city;
    }

    public BairroModels() {
    }

    public long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(long idBairro) {
        this.idBairro = idBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public CityModels getCity() {
        return city;
    }

    public void setCity(CityModels city) {
        this.city = city;
    }

    public List<EnderecoModels> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoModels> endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "BairroModels{" +
                "idBairro=" + idBairro +
                ", nomeBairro='" + nomeBairro + '\'' +
                ", city=" + city +
                ", endereco=" + endereco +
                '}';
    }
}
