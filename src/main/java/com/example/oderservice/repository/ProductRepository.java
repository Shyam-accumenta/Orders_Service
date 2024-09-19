package com.example.oderservice.repository;

import com.example.oderservice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Products ,Long> {
}
