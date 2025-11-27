package com.v1.springproject.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Component
public class ProductModel {

    private int id;
    private String title;
    private double price;
    private String Category;
    private String description;
    private String image;

}
