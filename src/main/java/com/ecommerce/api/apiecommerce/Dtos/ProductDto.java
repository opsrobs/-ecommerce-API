package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ProductDto {

    @NotNull
    private String nomeProduto;
    @NotNull
    private String descProduto;
    @NotNull
    private String URLImagem;
    @NotNull
    private String imagealt;
    @NotNull
    private float preco_produto;
    @NotNull
    private ProductTypeModels categories;

    public ProductDto(String nomeProduto, String descProduto, String URLImagem, String imagealt, float preco_produto, ProductTypeModels categories) {
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.URLImagem = URLImagem;
        this.imagealt = imagealt;
        this.preco_produto = preco_produto;
        this.categories = categories;
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

    public String getURLImagem() {
        return URLImagem;
    }

    public void setURLImagem(String URLImagem) {
        this.URLImagem = URLImagem;
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
    public String getImagealt() {
        return imagealt;
    }

    public void setImagealt(String imagealt) {
        this.imagealt = imagealt;
    }
    @Override
    public String toString() {
        return "ProductDto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", descProduto='" + descProduto + '\'' +
                ", URLImagem='" + URLImagem + '\'' +
                ", imagealt='" + imagealt + '\'' +
                ", preco_produto=" + preco_produto +
                ", categories=" + categories +
                '}';
    }
}
