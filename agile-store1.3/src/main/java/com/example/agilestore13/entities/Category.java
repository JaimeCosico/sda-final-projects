package com.example.agilestore13.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String categoryName;
    private long parentCategoryPos;
    private long childrenCategoryPos;

    public Category(String categoryName, long parentCategoryPos, long childrenCategoryPos) {
        this.categoryName = categoryName;
        this.parentCategoryPos = parentCategoryPos;
        this.childrenCategoryPos = childrenCategoryPos;
    }
}
