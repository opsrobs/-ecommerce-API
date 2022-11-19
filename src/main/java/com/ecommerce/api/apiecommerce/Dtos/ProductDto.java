package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.ProductTypeModels;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ProductDto {

    @NotNull
    private String nomeProduto;
    @NotNull
    private float preco_produto;
    @NotNull
    private ProductTypeModels categories;

    public ProductDto(String nomeProduto, float preco_produto, ProductTypeModels categories) {
        this.nomeProduto = nomeProduto;
        this.preco_produto = preco_produto;
        this.categories = categories;
    }

    public ProductDto() {
    }

    public String getnomeProduto() {
        return nomeProduto;
    }

    public void setnomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
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
}