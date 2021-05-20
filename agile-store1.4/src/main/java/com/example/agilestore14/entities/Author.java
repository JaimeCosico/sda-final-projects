package com.example.agilestore14.entities;
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
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message="Firstname is required.")
    private String firstName;

    @NotEmpty(message="Lastname is required.")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> productList;

    public Author(String firstName, String lastName, List<Product> productList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productList = productList;
    }
}
