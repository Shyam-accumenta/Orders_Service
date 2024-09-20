package com.example.oderservice.dtos;

import lombok.Data;

@Data

public class ResponseWrapper<T> {

    private T object;

    public ResponseWrapper(T object) {
        this.object = object;
    }

    private Object String;

}
