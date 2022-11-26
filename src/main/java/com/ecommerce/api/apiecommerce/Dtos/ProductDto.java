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
    private String pathImagem;
    @NotNull
    private float preco_produto;
    @NotNull
    private ProductTypeModels categories;

    public ProductDto() {
    }

    public ProductDto(String nomeProduto, String descProduto, String pathImagem, float preco_produto, ProductTypeModels categories) {
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.pathImagem = pathImagem;
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

    @Override
    public String toString() {
        return "ProductDto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", descProduto='" + descProduto + '\'' +
                ", pathImagem='" + pathImagem + '\'' +
                ", preco_produto=" + preco_produto +
                ", categories=" + categories +
                '}';
    }
}
