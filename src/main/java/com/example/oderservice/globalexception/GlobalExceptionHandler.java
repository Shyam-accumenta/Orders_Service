package com.example.oderservice.globalexception;

import com.example.oderservice.productdto.ResponseWrapper;
import com.example.oderservice.exception.ProductAlreadyExceptionExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {



    @ExceptionHandler(ProductAlreadyExceptionExists.class)
    public ResponseEntity<?> handleProductsNotFoundException(ProductAlreadyExceptionExists ex, WebRequest request)
    {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(ex));
    }
}
