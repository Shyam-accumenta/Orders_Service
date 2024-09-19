package com.example.oderservice.service;

import com.example.oderservice.model.Products;

import java.util.List;

public interface ProductService  {

    Products getProducts (long id);
    Products updateProducts(long id,Products products);
    Products deleteProducts(long id);
    List<Products> getAll();
    Products addProducts(Products products);
}
