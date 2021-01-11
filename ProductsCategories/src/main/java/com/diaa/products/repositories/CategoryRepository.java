package com.diaa.products.repositories;

import com.diaa.products.models.Category;
import com.diaa.products.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    void deleteById(Long id);
    @Query(value = "SELECT * FROM categories WHERE categories.id NOT IN(SELECT categories_products.category_id FROM categories_products WHERE product_id = id)", nativeQuery = true)
    List<Category> findNonProductCategories(Long id);
}
