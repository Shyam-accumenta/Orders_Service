package com.example.oderservice.dtos;

import lombok.Data;

@Data
public class UserResponse {
    private UserDto object;
    private String message;
}
