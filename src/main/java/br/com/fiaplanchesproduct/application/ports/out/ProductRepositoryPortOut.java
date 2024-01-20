package br.com.fiaplanchesproduct.application.ports.out;

import br.com.fiaplanchesproduct.application.dtos.ProductDto;
import br.com.fiaplanchesproduct.domain.enums.Category;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPortOut {

    Optional<List<ProductDto>> findProductByCategory(Category category);

    ProductDto saveProduct(ProductDto productDto);

    void deleteProduct(ProductDto productDto);

    Optional<ProductDto> findProductById(Long id);

    Optional<List<ProductDto>> findProductsByIds(List<Long> ids);
}
