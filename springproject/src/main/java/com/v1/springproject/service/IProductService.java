package com.v1.springproject.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.v1.springproject.DTO.ProductRequestDTO;
import com.v1.springproject.DTO.ProductResponseDTO;

import lombok.extern.apachecommons.CommonsLog;

@Component
public interface IProductService {

    public ProductResponseDTO getProductByid(int id);
    public List<ProductResponseDTO> getAllProducts();
  public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);
}
