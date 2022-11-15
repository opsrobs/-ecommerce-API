package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;

@Entity
@Table(name= "Stade")
public class StadeModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_stade;
    @Column(nullable = false)
    private String UF;
    @Column(nullable = false)
    private String nome_estado;

    public StadeModels(long id_stade, String UF, String nome_estado) {
        this.id_stade = id_stade;
        this.UF = UF;
        this.nome_estado = nome_estado;
    }

    public StadeModels() {
    }

    public long getId_stade() {
        return id_stade;
    }

    public void setId_stade(long id_stade) {
        this.id_stade = id_stade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    @Override
    public String toString() {
        return "StadeModels{" +
                "id_stade=" + id_stade +
                ", UF='" + UF + '\'' +
                ", nome_estado='" + nome_estado + '\'' +
                '}';
    }
}
