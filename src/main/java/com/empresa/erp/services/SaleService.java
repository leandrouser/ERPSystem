package com.empresa.erp.services;

import com.empresa.erp.models.*;
import com.empresa.erp.repositories.SaleRepository;
import com.empresa.erp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository; // Adicione este repositório para buscar o vendedor

    @Transactional
    public SaleModel realizarVenda(Long vendedorId, List<SaleItemModel> itens) {
        // Busca o vendedor no banco de dados
        UserModel vendedor = userRepository.findById(vendedorId)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado: " + vendedorId));

        SaleModel saleModel = new SaleModel();
        saleModel.setVendedor(vendedor);
        saleModel.setDataVenda(LocalDateTime.now());

        // Calcula o valor total da venda
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (SaleItemModel item : itens) {
            // Verifica se há estoque suficiente
            ProductModel productModel = productService.buscarPorId(item.getProductModel().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + item.getProductModel().getId()));

            if (productModel.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + productModel.getNome());
            }

            // Atualiza o estoque
            productModel.setQuantidadeEstoque(productModel.getQuantidadeEstoque() - item.getQuantidade());
            productService.salvar(productModel);

            // Define o preço unitário do item
            item.setPrecoUnitario(productModel.getPreco());

            // Adiciona ao valor total
            valorTotal = valorTotal.add(productModel.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));

            // Associa o item à venda
            item.setVenda(saleModel);
        }

        saleModel.setItens(itens);
        saleModel.setValorTotal(valorTotal);

        // Salva a venda
        return saleRepository.save(saleModel);
    }
}