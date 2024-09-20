package com.example.oderservice.globalexception;

import com.example.oderservice.dtos.ResponseWrapper;
import com.example.oderservice.exception.OrderAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {



    @ExceptionHandler(OrderAlreadyExistException.class)
    public ResponseEntity<?> handleProductsNotFoundException(OrderAlreadyExistException ex, WebRequest request)
    {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<>(ex));
    }
}
