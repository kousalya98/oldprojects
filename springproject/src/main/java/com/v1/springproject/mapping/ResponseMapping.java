package com.v1.springproject.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.v1.springproject.DTO.ProductResponseDTO;
import com.v1.springproject.model.ProductModel;

import lombok.Getter;
import lombok.Setter;

@Component
public class ResponseMapping {


    public ProductResponseDTO ConvertProductModeltoProductResponseDTO(ProductModel productModel){
                ProductResponseDTO prd=new ProductResponseDTO();
                prd.setId(productModel.getId());
                prd.setTitle(productModel.getTitle());
                prd.setPrice(productModel.getPrice());
                prd.setCategory(productModel.getCategory());
                prd.setDescription(productModel.getDescription());
                prd.setImage(productModel.getImage());

            return prd;
        
    }
    public List<ProductResponseDTO> ConvertProductModeltoListOfProductResponseDTO(ProductModel[] productModels){
        List<ProductResponseDTO> prd = new ArrayList<>();
        for(ProductModel product: productModels){
        ProductResponseDTO prod=new ProductResponseDTO();
        prod.setId(product.getId());
        prod.setTitle(product.getTitle());
        prod.setPrice(product.getPrice());
        prod.setCategory(product.getCategory());
        prod.setDescription(product.getDescription());
        prod.setImage(product.getImage());
        prd.add(prod);   
        }
        return prd;
    } 

}
