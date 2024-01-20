package br.com.fiaplanchesproduct.application.dtos;

import br.com.fiaplanchesproduct.domain.enums.Category;

import java.math.BigDecimal;

public record ResponseProductDto(Long id, String nomeProduto, BigDecimal preco, Category category) {

    public ResponseProductDto(Long id, String nomeProduto, BigDecimal preco, Category category) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.category = category;
    }

    public static ResponseProductDto toResponseProductDto(ProductDto productDTO) {
        return new ResponseProductDto(
                productDTO.id(),
                productDTO.nomeProduto(),
                productDTO.preco(),
                productDTO.category()
        );
    }

}