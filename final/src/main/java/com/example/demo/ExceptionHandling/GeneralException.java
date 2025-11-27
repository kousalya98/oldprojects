package com.example.demo.ExceptionHandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralException extends RuntimeException{
    public GeneralException(String message){
        super(message);
    }

}
