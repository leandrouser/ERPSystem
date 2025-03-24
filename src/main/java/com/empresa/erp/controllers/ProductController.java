package com.empresa.erp.controllers;

import com.empresa.erp.dtos.ProductDTO;
import com.empresa.erp.models.ProductModel;
import com.empresa.erp.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produtos", description = "Endpoints para gerenciamento de produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista de todos os produtos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso.")
    public List<ProductModel> listarTodos() {
        return productService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto específico com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ProductModel encontrado."),
            @ApiResponse(responseCode = "404", description = "ProductModel não encontrado.")
    })
    public ResponseEntity<ProductModel> buscarPorId(@PathVariable Long id) {
        return productService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo produto", description = "Cadastra um novo produto no sistema.")
    @ApiResponse(responseCode = "200", description = "ProductModel criado com sucesso.")
    public ProductModel salvar(@RequestBody ProductDTO productDTO) {
        ProductModel productModel = productService.converterParaProduto(productDTO);
        return productService.salvar(productModel);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir produto", description = "Remove um produto com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "ProductModel excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "ProductModel não encontrado.")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        productService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}