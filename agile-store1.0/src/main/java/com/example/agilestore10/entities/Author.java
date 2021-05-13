package com.example.agilestore10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String LastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }
}
