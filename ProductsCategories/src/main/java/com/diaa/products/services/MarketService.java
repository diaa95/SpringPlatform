package com.diaa.products.services;


import com.diaa.products.models.Category;
import com.diaa.products.models.Product;
import com.diaa.products.repositories.CategoryRepository;
import com.diaa.products.repositories.ProductRepository;
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

    public List<Product> nonCategoryProducts(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null)
            return null;
        return productRepository.findNonCategoryProducts(id);
    }
    public List<Category> nonProductCategories(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product == null)
            return null;
        return categoryRepository.findNonProductCategories(id);
    }
    public void addProductToCategory(Long product_id, Long category_id){
        Product product = productRepository.findById(product_id).orElse(null);
        Category category = categoryRepository.findById(category_id).orElse(null);
        List<Product> products = category.getProducts();
        List<Category> categories = product.getCategories();
        products.add(product);
        categories.add(category);
        category.setProducts(products);
        product.setCategories(categories);
        productRepository.save(product);
        categoryRepository.save(category);
//        addCategoryToProduct(category_id, product_id);
    }

//    public void addCategoryToProduct(Long category_id , Long product_id){
//        Product product = productRepository.findById(product_id).orElse(null);
//        Category category = categoryRepository.findById(category_id).orElse(null);
//        List<Category> categories = product.getCategories();
//        categories.add(category);
//        product.setCategories(categories);
//        productRepository.save(product);
//        addProductToCategory(product_id, category_id);
//    }

}
