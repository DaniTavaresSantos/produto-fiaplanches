package br.com.fiaplanchesproduct.application.usecases;

import br.com.fiaplanchesproduct.application.dtos.ProductDto;
import br.com.fiaplanchesproduct.application.ports.out.ProductRepositoryPortOut;

public class RegisterProductUseCase {

    private final ProductRepositoryPortOut productRepositoryPortOut;

    public RegisterProductUseCase(ProductRepositoryPortOut productRepositoryPortOut) {
        this.productRepositoryPortOut = productRepositoryPortOut;
    }

    public ProductDto registerProduct(ProductDto productDto) {
        return productRepositoryPortOut.saveProduct(productDto);
    }
}
