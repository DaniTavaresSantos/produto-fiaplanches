package br.com.fiaplanchesproduct.application.dtos;

import br.com.fiaplanchesproduct.domain.Product;
import br.com.fiaplanchesproduct.domain.enums.Category;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String nomeProduto,
        BigDecimal preco,
        Category category
) {
    public ProductDto(Long id, String nomeProduto, BigDecimal preco, Category category) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.category = category;
    }

    public static ProductDto toProductDto(Product produto) {
        return new ProductDto(
                produto.getId(),
                produto.getNomeProduto(),
                produto.getPreco(),
                produto.getCategory()
        );
    }

    public Product toProduct() {
        return new Product(
                this.id,
                this.nomeProduto,
                this.preco,
                this.category
        );
    }
}
