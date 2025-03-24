package com.empresa.erp.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class SaleItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private SaleModel saleModel;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel productModel;

    @Column(nullable = false, length = 5)
    private Integer quantidade;

    @Column(nullable = false, length = 10)
    private BigDecimal precoUnitario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SaleModel getVenda() {
        return saleModel;
    }

    public void setVenda(SaleModel saleModel) {
        this.saleModel = saleModel;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}