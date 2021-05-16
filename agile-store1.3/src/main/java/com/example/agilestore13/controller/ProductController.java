package com.example.agilestore13.controller;

import com.example.agilestore13.entities.Product;
import com.example.agilestore13.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/product/create_new")
    public Product addProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @GetMapping("/product/view_all")
    public List<Product> showAllProducts(){
        return productService.showAllProducts();
    }
}
