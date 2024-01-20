package br.com.fiaplanchesproduct.application.usecases;

import br.com.fiaplanchesproduct.application.dtos.ProductDto;
import br.com.fiaplanchesproduct.application.ports.out.ProductRepositoryPortOut;
import jakarta.persistence.EntityNotFoundException;

public class DeleteProductUseCase {

    private final ProductRepositoryPortOut productRepositoryPortOut;

    public DeleteProductUseCase(ProductRepositoryPortOut productRepositoryPortOut) {
        this.productRepositoryPortOut = productRepositoryPortOut;
    }

    public void deleteProduct(Long id) {
        ProductDto productDto = productRepositoryPortOut.findProductById(id).orElseThrow(
                () -> new EntityNotFoundException("Produto não encontrado")
        );
        productRepositoryPortOut.deleteProduct(productDto);
    }
}
