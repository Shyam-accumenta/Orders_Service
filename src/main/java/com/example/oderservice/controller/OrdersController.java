package com.example.oderservice.controller;

import com.example.oderservice.model.Orders;
import com.example.oderservice.dtos.ResponseWrapper;
import com.example.oderservice.service.OrdersService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping(value = "/order/{userMobileNumber}",produces ="application/json")
    public ResponseEntity<ResponseWrapper<String>> saveProducts(@RequestBody Orders orders,@PathVariable long userMobileNumber)
    {
        String dbOrders =this.ordersService.addOrUpdateOrders(orders,userMobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(dbOrders));
    }
    @GetMapping(value="/orders",produces="application/json")
    public ResponseEntity<ResponseWrapper<List<Orders>>> getProducts()
    {
        List<Orders> dbProducts=this.ordersService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(dbProducts));
    }

    @GetMapping(value = "/order/{userMobileNumber}",produces="application/json")
    public ResponseEntity<ResponseWrapper<List<Orders>>> getProducts(@PathVariable long userMobileNumber)
    {
        List<Orders> dbOrders =this.ordersService.getProducts(userMobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper<>(dbOrders));
    }
}
