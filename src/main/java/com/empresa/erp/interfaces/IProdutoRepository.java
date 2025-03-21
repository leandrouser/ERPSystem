package com.empresa.erp.interfaces;


import com.empresa.erp.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {

    // Buscar produtos por nome (ignorando maiúsculas e minúsculas)
    List<Produto> findByNomeIgnoreCaseContaining(String nome);

    // Buscar produtos dentro de uma faixa de preço
    List<Produto> findByPrecoBetween(Double precoMin, Double precoMax);

    // Buscar produtos por descrição contendo uma palavra-chave
    @Query("SELECT p FROM Produto p WHERE LOWER(p.descricao) LIKE LOWER(CONCAT('%', :descricao, '%'))")
    List<Produto> buscarPorDescricao(@Param("descricao") String descricao);
}
