package com.diaa.market.repositories;

import com.diaa.market.models.Category;
import com.diaa.market.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    List<Category> findByProductsNotContaining(Product product);

 }
