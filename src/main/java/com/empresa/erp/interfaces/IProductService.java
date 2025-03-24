package com.empresa.erp.interfaces;

import com.empresa.erp.dtos.ProductDTO;
import com.empresa.erp.models.ProductModel;

import java.util.List;

public interface IProductService {

    ProductDTO salvarProduto(ProductDTO productDTO);
    ProductDTO atualizarProduto(Long id, ProductDTO productDTO);
    void deletarProduto(Long id);
    List<ProductModel> listarProdutos();
    ProductDTO buscarProdutoPorId(Long id);
    List<ProductModel> buscarPorNome(String nome);
    List<ProductModel> buscarPorFaixaDePreco(Double precoMin, Double precoMax);
    List<ProductModel> buscarPorDescricao(String descricao);
}