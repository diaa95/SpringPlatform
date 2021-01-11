package com.diaa.market.services;


import com.diaa.market.models.Category;
import com.diaa.market.models.Product;
import com.diaa.market.repositories.CategoryRepository;
import com.diaa.market.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public MarketService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public Product getProduct(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> allProducts(){
        return productRepository.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }

    public List<Product> nonCategoryProducts(Long category_id){
        Category category = categoryRepository.findById(category_id).orElse(null);
        if(category == null)
            return null;
        return productRepository.findByCategoriesNotContaining(category);
    }
    public List<Category> nonProductCategories(Long product_id){
        Product product = productRepository.findById(product_id).orElse(null);
        if(product == null)
            return null;
        return categoryRepository.findByProductsNotContaining(product);
    }

    public void add(Long product_id, Long category_id){
        Product product = productRepository.findById(product_id).orElse(null);
        Category category = categoryRepository.findById(category_id).orElse(null);
        assert category != null;
        List<Product> products = category.getProducts();
        assert product != null;
        List<Category> categories = product.getCategories();
        products.add(product);
        category.setProducts(products);
        categoryRepository.save(category);
    }
}
