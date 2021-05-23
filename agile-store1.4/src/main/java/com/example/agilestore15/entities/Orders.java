package com.example.agilestore15.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private UserAccount userAccount;

    @Min(value=0)
    private double totalCost;

    @NotEmpty(message="Delivery address is required.")
    private String deliveryAddress;

    @NotEmpty(message="Home address is required")
    private String userAddress;

    @JsonFormat(pattern="yyy-mm-dd")
    private LocalDate dateOfSubmission;

    @ManyToOne
    private Users users;

    @NotEmpty(message="Please select status.")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderLine> orderLineList;

    public Orders(UserAccount userAccount, double totalCost, String deliveryAddress, String userAddress, LocalDate dateOfSubmission, Users users, Status status, List<OrderLine> orderLineList) {
        this.userAccount = userAccount;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfSubmission = dateOfSubmission;
        this.users = users;
        this.status = status;
        this.orderLineList = orderLineList;
    }
}
