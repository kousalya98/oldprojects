package com.v1.springproject.mapping;

import org.springframework.stereotype.Component;

import com.v1.springproject.DTO.ProductRequestDTO;
import com.v1.springproject.model.ProductModel;

@Component
public class RequestMapping {

    public ProductModel convertProductRequstDTOtoProductModel(ProductRequestDTO productRequestDTO){
        ProductModel pm=new ProductModel();
    
        pm.setTitle(productRequestDTO.getTitle());
        pm.setPrice(productRequestDTO.getPrice());
        pm.setCategory(productRequestDTO.getCategory());
        pm.setDescription(productRequestDTO.getDescription());
        pm.setImage(productRequestDTO.getImage());
        return pm;

    }
    
  
}
