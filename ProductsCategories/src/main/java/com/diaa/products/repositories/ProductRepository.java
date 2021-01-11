package com.diaa.products.repositories;

import com.diaa.products.models.Category;
import com.diaa.products.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    void deleteById(Long id);
    @Query(value = "SELECT * FROM products WHERE products.id NOT IN(SELECT categories_products.product_id FROM categories_products WHERE category_id = id)", nativeQuery = true)
    List<Product> findNonCategoryProducts(Long id);
}
