package com.diaa.market.repositories;

import com.diaa.market.models.Category;
import com.diaa.market.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    List<Product> findByCategoriesNotContaining(Category category);
}
