package com.example.oderservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private String orderPrice;
    private String orderedDate;
    private String orderLocation;
    private List<String> products;
    private long userId;

}

