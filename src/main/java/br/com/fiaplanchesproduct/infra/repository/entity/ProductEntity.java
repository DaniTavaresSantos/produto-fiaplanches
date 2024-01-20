package br.com.fiaplanchesproduct.infra.repository.entity;

import br.com.fiaplanchesproduct.application.dtos.ProductDto;
import br.com.fiaplanchesproduct.domain.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private Category category;

    public static ProductEntity toProductEntity(ProductDto productDTO) {
        return new ProductEntity(
                productDTO.id(),
                productDTO.nomeProduto(),
                productDTO.preco(),
                productDTO.category()
        );
    }

    public ProductDto toProductDto() {
        return new ProductDto(
                this.id,
                this.nomeProduto,
                this.preco,
                this.category
        );
    }
}
