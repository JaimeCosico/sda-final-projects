package com.example.agilestore10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String productTitle;
    private String productDescription;
    private String thumbnailUrl;
    @OneToOne
    private Category category;
    private double price;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @OneToOne
    private Author author;
    private String edition;

    public Product(String productTitle, String productDescription, String thumbnailUrl, Category category, double price, ProductType productType, Author author, String edition) {
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.thumbnailUrl = thumbnailUrl;
        this.category = category;
        this.price = price;
        this.productType = productType;
        this.author = author;
        this.edition = edition;
    }
}
