package com.v1.springproject.DTO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class ProductRequestDTO {
  
    private String title;
    private double price;
    private String Category;
    private String description;
    private String image;
}
