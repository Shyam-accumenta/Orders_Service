package com.example.oderservice.service;

import com.example.oderservice.model.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> getProducts (long userMobileNumber);
    List<Orders> getAll();
    String addOrUpdateOrders(Orders orders,long userMobileNumber);
}
