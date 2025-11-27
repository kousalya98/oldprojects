package com.example.demo.ExceptionHandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsListNotFoundException extends RuntimeException{
    public ProductsListNotFoundException(String message){
        super(message);
    }

}
