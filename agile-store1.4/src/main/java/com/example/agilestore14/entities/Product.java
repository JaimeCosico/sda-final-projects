package com.example.agilestore14.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message="Product title is required.")
    private String productTitle;

    @NotEmpty(message="Product description is required.")
    private String productDescription;

    @NotEmpty(message="Thumbnail Url is required.")
    private String thumbnailUrl;

    @NotNull
    @ManyToOne
    private Category category;

    @NotEmpty(message="Unit price is required.")
    private double unitPrice;

    @NotEmpty(message="Please select a product type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @NotNull

    @ManyToOne
    private Author author;

    @NotEmpty(message="Product edition/generation/version is required.")
    private String edition;

    public Product(String productTitle, String productDescription, String thumbnailUrl, Category category, double unitPrice, ProductType productType, Author author, String edition) {
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.thumbnailUrl = thumbnailUrl;
        this.category = category;
        this.unitPrice = unitPrice;
        this.productType = productType;
        this.author = author;
        this.edition = edition;
    }
}
