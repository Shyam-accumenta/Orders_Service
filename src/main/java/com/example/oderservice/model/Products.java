package com.example.oderservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderId;
    private String orderPrice;
    private String orderedDate;
    private String orderLocation;
    private List<String> products;
    private String userId;

}

