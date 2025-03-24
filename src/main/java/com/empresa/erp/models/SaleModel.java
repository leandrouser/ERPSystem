package com.empresa.erp.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private UserModel vendedor;

    @Column(nullable = false)
    private LocalDateTime dataVenda;

    @OneToMany(mappedBy = "saleModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItemModel> itens;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(UserModel vendedor) {
        this.vendedor = vendedor;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<SaleItemModel> getItens() {
        return itens;
    }

    public void setItens(List<SaleItemModel> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}