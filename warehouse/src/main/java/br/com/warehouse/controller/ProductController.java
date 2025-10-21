package br.com.warehouse.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import br.com.warehouse.entity.Product;
import br.com.warehouse.repository.ProductRepository;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "API de Produtos", description = "Operações CRUD para gerenciar produtos no armazém")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    @Operation(summary = "Lista todos os produtos")
    public List<Product> listarTodos() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um produto por ID")
    public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria um novo produto")
    public Product criarProduto(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um produto existente")
    public ResponseEntity<Product> atualizarProduto(@PathVariable Long id, @RequestBody Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setNome(productDetails.getNome());
                    product.setDescricao(productDetails.getDescricao());
                    product.setPreco(productDetails.getPreco());
                    product.setQuantidadeEmEstoque(productDetails.getQuantidadeEmEstoque());
                    Product updatedProduct = productRepository.save(product);
                    return ResponseEntity.ok(updatedProduct);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um produto")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
