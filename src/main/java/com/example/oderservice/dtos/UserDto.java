package com.example.oderservice.dtos;

import lombok.Data;

@Data
public class UserDto {

    private long userId;
    private  String userName;
    private String userEmail;
    private long userNumber;
}
