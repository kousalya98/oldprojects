package com.example.demo.Model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Product {
    private int id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
}
