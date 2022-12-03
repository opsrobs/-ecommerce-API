package com.ecommerce.api.apiecommerce.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Stade")
public class StadeModels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEstado;
    @Column(nullable = true)
    private String UF;
    @Column(nullable = false)
    private String nome_estado;
    @OneToMany(mappedBy = "stade", fetch = FetchType.EAGER)
    private List<CityModels> city;

    public StadeModels(long idEstado, String UF, String nome_estado) {
        this.idEstado = idEstado;
        this.UF = UF;
        this.nome_estado = nome_estado;
    }

    public StadeModels() {
    }

    public long getidEstado() {
        return idEstado;
    }

    public void setidEstado(long idEstado) {
        this.idEstado = idEstado;
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
                "idEstado=" + idEstado +
                ", UF='" + UF + '\'' +
                ", nome_estado='" + nome_estado + '\'' +
                '}';
    }
}
