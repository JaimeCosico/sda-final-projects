package com.example.agilestore15.form;

import com.example.agilestore15.entities.Author;
import com.example.agilestore15.entities.Category;
import com.example.agilestore15.entities.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsForm {

    private long id;
    private String productTitle;
    private String productDescription;
    private String thumbnailUrl;
    private Category category;
    private double unitPrice;
    private ProductType productType;
    private Author author;
    private String edition;


}
