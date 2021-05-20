package com.example.agilestore14.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private UserAccount userAccount;
    private double totalCost;
    @NotEmpty(message="Delivery address is required.")
    private String deliveryAddress;
    @NotEmpty(message="Delivery address is required")
    private String userAddress;
    private LocalDate dateOfSubmission;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Orders(UserAccount userAccount, double totalCost, String deliveryAddress, String userAddress, LocalDate dateOfSubmission, Users users, Status status) {
        this.userAccount = userAccount;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfSubmission = dateOfSubmission;
        this.users = users;
        this.status = status;
    }
}
