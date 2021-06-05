package com.example.agilestore15.controller;


import com.example.agilestore15.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/store")
    public String showProductsCart(){
        return "product-store";
    }
}
