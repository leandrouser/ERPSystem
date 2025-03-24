package com.empresa.erp.interfaces;


import com.empresa.erp.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IProductRepository extends JpaRepository<ProductModel, Long> {

    // Buscar produtos por nome (ignorando maiúsculas e minúsculas)
    List<ProductModel> findByNomeIgnoreCaseContaining(String nome);

    // Buscar produtos dentro de uma faixa de preço
    List<ProductModel> findByPrecoBetween(BigDecimal precoMin, BigDecimal precoMax);

    // Buscar produtos por descrição contendo uma palavra-chave
    @Query("SELECT p FROM ProductModel p WHERE LOWER(p.descricao) LIKE LOWER(CONCAT('%', :descricao, '%'))")
    List<ProductModel> buscarPorDescricao(@Param("descricao") String descricao);
}
