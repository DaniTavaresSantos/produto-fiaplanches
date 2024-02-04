package br.com.fiaplanchesproduct.domain;

import br.com.fiaplanchesproduct.domain.enums.Category;
import br.com.fiaplanchesproduct.generated.Generated;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String nomeProduto;
    private BigDecimal preco;
    private Category category;

    @Generated
    public Product() {
    }

    public Product(Long id, String nomeProduto, BigDecimal preco, Category category) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(nomeProduto, product.nomeProduto) && Objects.equals(preco, product.preco) && category == product.category;
    }

    @Generated
    @Override
    public int hashCode() {
        return Objects.hash(id, nomeProduto, preco, category);
    }

    public Product updateProduct(Product novoProduto) {
        if (!novoProduto.getNomeProduto().isEmpty() & novoProduto.getNomeProduto() != null) {
            setNomeProduto(novoProduto.getNomeProduto());
        }
        if (novoProduto.getCategory() != null) {
            setCategory(novoProduto.getCategory());
        }
        if (novoProduto.getPreco() != null) {
            setPreco(novoProduto.getPreco());
        }

        return this;
    }
}