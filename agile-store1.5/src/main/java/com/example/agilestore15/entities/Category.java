package com.example.agilestore15.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message="A category name is required")
    private String categoryName;

    @NotEmpty(message="Parent Category Id required")
    private long parentCategoryId;

    @NotEmpty(message="Child Category Id required")
    private long childCategoryId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> productList;

    public Category(String categoryName, long parentCategoryId, long childCategoryId, List<Product> productList) {
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
        this.childCategoryId = childCategoryId;
        this.productList = productList;
    }
}

