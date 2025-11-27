package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ProductResponseDTO;

@Component
public interface IProductService {
    public ProductResponseDTO getSingleProduct(int id);
    public List<ProductResponseDTO> getAllProducts();

}
