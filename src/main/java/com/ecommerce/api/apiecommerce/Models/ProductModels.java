package com.ecommerce.api.apiecommerce.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name= "Produto")
public class ProductModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column( nullable = false)
    private String nomeProduto;
    @Column( nullable = false)
    private String descProduto;
    @Column( nullable = true)
    private String pathImagem;
    @Column( nullable = true)
    private String nomeImagem1;
    @Column( nullable = true)
    private String nomeImagem2;
    @Column( nullable = false)
    private float preco_produto;

    @JsonIgnore
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private ProductTypeModels categories;


    public ProductModels() {
    }

    public ProductModels(long id, String nomeProduto, String descProduto, String pathImagem, float preco_produto, ProductTypeModels categories) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.pathImagem = pathImagem;
        this.preco_produto = preco_produto;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getPathImagem() {
        return pathImagem;
    }

    public void setPathImagem(String pathImagem) {
        this.pathImagem = pathImagem;
    }

    public float getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(float preco_produto) {
        this.preco_produto = preco_produto;
    }

    public ProductTypeModels getCategories() {
        return categories;
    }

    public void setCategories(ProductTypeModels categories) {
        this.categories = categories;
    }

    public String getNomeImagem1() {
        return nomeImagem1;
    }

    public void setNomeImagem1(String nomeImagem1) {
        this.nomeImagem1 = nomeImagem1;
    }

    public String getNomeImagem2() {
        return nomeImagem2;
    }

    public void setNomeImagem2(String nomeImagem2) {
        this.nomeImagem2 = nomeImagem2;
    }

    @Override
    public String toString() {
        return "ProductModels{" +
                "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", descProduto='" + descProduto + '\'' +
                ", pathImagem='" + pathImagem + '\'' +
                ", preco_produto=" + preco_produto +
                ", categories=" + categories +
                '}';
    }
}
