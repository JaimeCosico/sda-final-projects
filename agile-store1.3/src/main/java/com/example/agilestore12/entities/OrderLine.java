package com.example.agilestore12.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Product product;
    private long numberOfProducts;
    private double numberOfProductsPrice;
    @ManyToOne
    private Orders orders;

    public OrderLine(Product product, long numberOfProducts, double numberOfProductsPrice, Orders orders) {
        this.product = product;
        this.numberOfProducts = numberOfProducts;
        this.numberOfProductsPrice = numberOfProductsPrice;
        this.orders = orders;
    }
}
