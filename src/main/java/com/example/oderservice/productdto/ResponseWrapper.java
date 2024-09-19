package com.example.oderservice.productdto;

import lombok.Data;

@Data

public class ResponseWrapper<T> {

    private T object;

    public ResponseWrapper(T object) {
        this.object = object;
    }

    private Object String;

}
