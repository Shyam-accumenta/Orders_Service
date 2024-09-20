package com.example.oderservice.repository;

import com.example.oderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

    @Query("SELECT o FROM Orders o WHERE o.userId = :userId")
    List<Orders> findOrdersByUserMobileNumber(long userId);
}
