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
    private float preco_produto;

    @Column (nullable = false)
    private String imagePath;

    @JsonIgnore
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private ProductTypeModels categories;

    public ProductModels(long id, String nomeProduto, float preco_produto, String imagePath, ProductTypeModels categories) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco_produto = preco_produto;
        this.imagePath = imagePath;
        this.categories = categories;
    }

    public ProductModels(long id, String nomeProduto, float preco_produto, ProductTypeModels categories) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco_produto = preco_produto;
        this.categories = categories;
    }

    public ProductModels() {
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

    public float getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(float preco_produto) {
        this.preco_produto = preco_produto;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ProductTypeModels getCategories() {
        return categories;
    }

    public void setCategories(ProductTypeModels categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ProductModels{" +
                "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", preco_produto=" + preco_produto +
                ", imagePath='" + imagePath + '\'' +
                ", categories=" + categories +
                '}';
    }
}
