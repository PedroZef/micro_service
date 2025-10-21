package br.com.storefront.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEmEstoque;

}
