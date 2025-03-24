package com.empresa.erp.controllers;

import com.empresa.erp.dtos.SaleDTO;
import com.empresa.erp.models.*;
import com.empresa.erp.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendas")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public SaleModel realizarVenda(@RequestBody SaleDTO saleDTO) {
        // Delega a lógica de realização da venda para o serviço
        return saleService.realizarVenda(saleDTO.getVendedorId(), saleDTO.getItens());
    }
}