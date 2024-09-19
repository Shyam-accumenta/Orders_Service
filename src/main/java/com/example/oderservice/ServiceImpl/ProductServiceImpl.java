package com.example.oderservice.ServiceImpl;

import com.example.oderservice.exception.ProductAlreadyExceptionExists;
import com.example.oderservice.model.Products;
import com.example.oderservice.repository.ProductRepository;
import com.example.oderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;



    @Override
    public Products getProducts(long id) {

        Products dbProducts = this.productRepository.findById(id).get();
        if (dbProducts != null) {
            return this.productRepository.findById(id).get();
        } else {
            throw new ProductAlreadyExceptionExists("Products Id Already Exists");

        }
    }

    @Override
    public Products updateProducts(long id, Products products) {

        Products dbProducts1 = this.productRepository.findById(id).get();
        if (dbProducts1 != null) {
            dbProducts1.setId(id);
            dbProducts1.setOrderId(products.getOrderId());
            dbProducts1.setOrderedDate(products.getOrderedDate());
            dbProducts1.setOrderPrice(products.getOrderPrice());
            dbProducts1.setOrderLocation(products.getOrderLocation());
            dbProducts1.setUserId(products.getUserId());
            dbProducts1.setProducts(products.getProducts());
            return this.productRepository.save(dbProducts1);
        } else {
            throw new ProductAlreadyExceptionExists("Already exists");
        }
    }


    @Override
    public Products deleteProducts(long id) {
        Products dbProducts = this.productRepository.findById(id).get();
        if (dbProducts != null) {
            this.productRepository.delete(dbProducts);
        } else {

            throw new ProductAlreadyExceptionExists("Products Id Already Exists");
        }
        return null;
    }



    @Override
    public List<Products> getAll() {
        return this.productRepository.findAll();

    }

    @Override
    public Products addProducts(Products products) {
        Products dbProducts1 = this.productRepository.findById(products.getId()).orElse(null);
        if (dbProducts1  == null) {
            return this.productRepository.save(products);
        } else
        {
            throw new ProductAlreadyExceptionExists("products is not found");
        }
    }

    }













