package br.com.fiaplanchesproduct.infra.repository;

import br.com.fiaplanchesproduct.domain.enums.Category;
import br.com.fiaplanchesproduct.infra.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostGresProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategory(Category category);
}
