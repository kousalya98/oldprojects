package com.example.demo.Mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.Model.Product;

@Component
public class ProductResponseMapping {

    public ProductResponseDTO ConvertProductToProductResponseDTO(Product product){
        ProductResponseDTO res=new ProductResponseDTO(product);
        return res;

    }
    public List<ProductResponseDTO> ConvertallProductToListProductResponseDTO(Product[] products){
        List<ProductResponseDTO> dto=new ArrayList();
        for(Product product:products){
            ProductResponseDTO responseDTO=new ProductResponseDTO(product);
            dto.add(responseDTO);
        }
        return dto;

    }

}
