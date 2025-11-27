package com.example.demo.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
}
