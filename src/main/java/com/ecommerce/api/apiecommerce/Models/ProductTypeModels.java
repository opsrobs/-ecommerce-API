package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;

@Entity
@Table(name= "Tipo_Produto")
public class ProductTypeModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_tipo;
    @Column(nullable = false)
    private String nomeTipo;

    public ProductTypeModels(long id_tipo, String nomeTipo) {
        this.id_tipo = id_tipo;
        this.nomeTipo = nomeTipo;
    }

    public ProductTypeModels() {
    }

    public long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }
}
