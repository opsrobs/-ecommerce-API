package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Tipo_Produto")
public class ProductTypeModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nomeTipo;

    @OneToMany(mappedBy = "categories", fetch = FetchType.EAGER) // OneToMany associate aos contacts
    @Fetch(FetchMode.SUBSELECT)
    private List<ProductModels> produtos;

    public ProductTypeModels(long id, String nomeTipo, List<ProductModels> produtos) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.produtos = produtos;
    }

    public ProductTypeModels() {
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

}
