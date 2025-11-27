package com.v1.springproject.DTO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String Category;
    private String description;
    private String image;

}
