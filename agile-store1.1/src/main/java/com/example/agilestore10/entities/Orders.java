package com.example.agilestore10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String userName;
    private double totalCost;
    private String deliveryAddress;
    private String userAddress;
    private LocalDate dateOfSubmission;
    @ManyToOne
    private Users users;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Orders(String userName, double totalCost, String deliveryAddress, String userAddress, LocalDate dateOfSubmission, Users users, Status status) {
        this.userName = userName;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfSubmission = dateOfSubmission;
        this.users = users;
        this.status = status;
    }
}
