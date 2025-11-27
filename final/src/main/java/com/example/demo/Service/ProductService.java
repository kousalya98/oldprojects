package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.ExceptionHandling.GeneralException;
import com.example.demo.ExceptionHandling.ProductNotFoundException;
import com.example.demo.ExceptionHandling.ProductsListNotFoundException;
import com.example.demo.Mapping.ProductResponseMapping;
import com.example.demo.Model.Product;

@Service
public class ProductService implements IProductService{

    private Product product;
    private ProductResponseMapping productResponseMapping;
    
    @Autowired
    public ProductService( Product product, ProductResponseMapping productResponseMapping ) {
        this.product = product;
        this.productResponseMapping=productResponseMapping;
    }
    RestTemplate rest=new RestTemplate();

    public ProductResponseDTO getSingleProduct(int id) {
        try{
        String url="https://fakestoreapi.com/products/"+id;
        ProductResponseDTO productresponsedto=new ProductResponseDTO(product);
        ResponseEntity<Product> Productresult=rest.getForEntity(url, Product.class);
        if(Productresult.getBody()!=null){
           if(Productresult.getStatusCode().equals(HttpStatusCode.valueOf(200))){
           productresponsedto=productResponseMapping.ConvertProductToProductResponseDTO(Productresult.getBody());
          
            }
            return productresponsedto;
       }
        else{
            throw new ProductNotFoundException("Given Product id is not Present in Product list");
        }
    }
    catch(Exception ex){
        throw new GeneralException("Some system error"+ex.getMessage());
    }
      
    }

    public List<ProductResponseDTO> getAllProducts() {
        String url="https://fakestoreapi.com/products";
        ResponseEntity<Product[]> productresult=rest.getForEntity(url, Product[].class);
        List<ProductResponseDTO> dto=new ArrayList<>();
        if(productresult.getStatusCode().equals(HttpStatusCode.valueOf(200))){
              dto=productResponseMapping.ConvertallProductToListProductResponseDTO(productresult.getBody());
        }
        else{
            throw new ProductsListNotFoundException("LIst of product which are present not found or Product list is empty");
        }
        return dto;
    }
}

