package com.example.agilestore13.services;

import com.example.agilestore13.entities.Product;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private Map<Long, Product> productMap = new HashMap<>();
    private SecureRandom secureRandom = new SecureRandom();

    //adding of new products; it will return the Product object type.
    public Product addNewProduct(Product newProduct){
        Product product=new Product();
        product.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
        product.setProductTitle(newProduct.getProductTitle());
        product.setProductDescription(newProduct.getProductDescription());
        product.setThumbnailUrl(newProduct.getThumbnailUrl());
        product.setCategory(newProduct.getCategory());
        product.setProductType(newProduct.getProductType());
        product.setAuthor(newProduct.getAuthor());
        product.setEdition(newProduct.getEdition());
        productMap.put(product.getId(),product);
        return product;
    }
    //Shows all the products in the database
    public List<Product> showAllProducts() {
        return productMap.values().stream().collect(Collectors.toList());
    }
}
