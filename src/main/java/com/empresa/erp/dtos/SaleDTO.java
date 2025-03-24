package com.empresa.erp.dtos;

import com.empresa.erp.models.SaleItemModel;

import java.util.List;

public class SaleDTO {
    private Long vendedorId;
    private List<SaleItemModel> itens;

    // Getters e Setters
    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public List<SaleItemModel> getItens() {
        return itens;
    }

    public void setItens(List<SaleItemModel> itens) {
        this.itens = itens;
    }
}