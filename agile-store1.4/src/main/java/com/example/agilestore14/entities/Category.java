package com.example.agilestore14.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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

    public Category(String categoryName, long parentCategoryId, long childCategoryId) {
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
        this.childCategoryId = childCategoryId;
    }
}

