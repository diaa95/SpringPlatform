package com.diaa.market.controller;



import com.diaa.market.models.Category;
import com.diaa.market.models.Product;
import com.diaa.market.services.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MarketController {
    private MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @RequestMapping("/")
    public String allCategories(Model model){
        List<Category> categories = marketService.allCategories();
        model.addAttribute("categories", categories);
        return "market/allCategories.jsp";
    }
    @RequestMapping("/products")
    public String allProducts(Model model){
        List<Product> products = marketService.allProducts();
        model.addAttribute("products", products);
        return "market/allProducts.jsp";
    }

    @RequestMapping("/categories/new")
    public String addCategory(@ModelAttribute("category") Category category){
        return "market/addCategory.jsp";
    }

    @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "market/addCategory.jsp";
        } else {
            marketService.addCategory(category);
            return "redirect:/";
        }
    }
    @RequestMapping("/products/new")
    public String addProduct(@ModelAttribute("product") Product product){
        return "market/addProduct.jsp";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "market/addProduct.jsp";
        } else {
            marketService.addProduct(product);
            return "redirect:/products";
        }
    }
    @RequestMapping("categories/{id}")
    public String showCategory(Model model, @PathVariable("id") Long id){
        List<Product> products = marketService.nonCategoryProducts(id);
        model.addAttribute("products", products);
        Category category = marketService.getCategory(id);
        model .addAttribute("category", category);
        return "market/Category.jsp";
    }
    @RequestMapping(value = "categories/{id}", method = RequestMethod.POST)
    public String addProductToCategory(@PathVariable("id") Long category_id, @RequestParam("product") Long product_id){
        marketService.add(product_id, category_id);
        return "redirect:/categories/"+category_id;
    }
    @RequestMapping("products/{id}")
    public String showProduct(Model model, @PathVariable("id") Long id){
        List<Category> categories = marketService.nonProductCategories(id);
        model.addAttribute("categories", categories);
        Product product = marketService.getProduct(id);
        model .addAttribute("product", product);
        return "market/Product.jsp";
    }
    @RequestMapping(value = "products/{id}", method = RequestMethod.POST)
    public String addCategoryToProduct(@PathVariable("id") Long product_id, @RequestParam("category") Long category_id){
        marketService.add(product_id, category_id);
        return "redirect:/products/"+product_id;
    }
}
