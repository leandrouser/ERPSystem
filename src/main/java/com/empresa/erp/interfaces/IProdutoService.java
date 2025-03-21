package com.empresa.erp.interfaces;

import com.empresa.erp.dtos.ProdutoDTO;
import com.empresa.erp.models.Produto;

import java.util.List;

public interface IProdutoService {

    ProdutoDTO salvarProduto(ProdutoDTO produtoDTO);
    ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO);
    void deletarProduto(Long id);
    List<Produto> listarProdutos();
    ProdutoDTO buscarProdutoPorId(Long id);
    List<Produto> buscarPorNome(String nome);
    List<Produto> buscarPorFaixaDePreco(Double precoMin, Double precoMax);
    List<Produto> buscarPorDescricao(String descricao);
}