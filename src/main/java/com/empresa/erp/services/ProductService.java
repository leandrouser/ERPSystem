package com.empresa.erp.services;

import com.empresa.erp.dtos.ProductDTO;
import com.empresa.erp.models.ProductModel;
import com.empresa.erp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> listarTodos() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> buscarPorId(Long id) {
        return productRepository.findById(id);
    }

    public ProductModel salvar(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public void deletar(Long id) {
        productRepository.deleteById(id);
    }

    public ProductModel converterParaProduto(ProductDTO productDTO) {
        if (productDTO == null) {
            throw new IllegalArgumentException("ProductDTO não pode ser nulo.");
        }

        ProductModel productModel = new ProductModel();
        productModel.setNome(productDTO.getNome());
        productModel.setDescricao(productDTO.getDescricao());
        productModel.setPreco(productDTO.getPreco());
        productModel.setQuantidadeEstoque(productDTO.getQuantidadeEstoque());
        return productModel;
    }
}