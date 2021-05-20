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
public class OrderLine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    @NotEmpty(message="Product quantity is required.")
    private long numberOfProducts;
    private double numberOfProductsPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private Orders orders;

    public OrderLine(Product product, long numberOfProducts, double numberOfProductsPrice, Orders orders) {
        this.product = product;
        this.numberOfProducts = numberOfProducts;
        this.numberOfProductsPrice = numberOfProductsPrice;
        this.orders = orders;
    }
}
