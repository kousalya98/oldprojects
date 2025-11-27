package com.v1.springproject.service;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.v1.springproject.DTO.ProductRequestDTO;
import com.v1.springproject.DTO.ProductResponseDTO;
import com.v1.springproject.mapping.RequestMapping;
import com.v1.springproject.mapping.ResponseMapping;
import com.v1.springproject.model.ProductModel;

@Service
public class ProductService implements IProductService{
    //public RestTemplate rest;
    private ResponseMapping responseMapping;
    private RequestMapping requestMapping;
    @Autowired
    ProductService(ResponseMapping responseMapping, RequestMapping requestMapping){
        this.responseMapping=responseMapping;
        this.requestMapping=requestMapping;
    }
   RestTemplate rest=new RestTemplate();

    public ProductResponseDTO getProductByid(int id){
        String url = "https://fakestoreapi.com/products/"+id;
        ProductResponseDTO prd=new ProductResponseDTO();
        ResponseEntity<ProductModel> product=rest.getForEntity(url, ProductModel.class);
        if(product.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            prd= responseMapping.ConvertProductModeltoProductResponseDTO(product.getBody());
        }
        return prd;
    }
    public List<ProductResponseDTO> getAllProducts(){
        String url="https://fakestoreapi.com/products/";
        ResponseEntity<ProductModel[]> product=rest.getForEntity(url, ProductModel[].class);
        List<ProductResponseDTO> prd=new ArrayList<>();
        if(product.getStatusCode().equals(HttpStatusCode.valueOf(200))){
               prd=responseMapping.ConvertProductModeltoListOfProductResponseDTO(product.getBody());
        }
        return prd;

    }
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        String url="https://fakestoreapi.com/products";
        ProductResponseDTO prd=new ProductResponseDTO();
        ProductModel req=requestMapping.convertProductRequstDTOtoProductModel(productRequestDTO);
        ResponseEntity<ProductModel> res=rest.postForEntity(url, req,ProductModel.class);
        if(res.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            prd=responseMapping.ConvertProductModeltoProductResponseDTO(res.getBody());
        }
    return prd;

    }
    public ProductResponseDTO updateProductdetail(int id, ProductRequestDTO productRequestDTO) {
        // TODO Auto-generated method stub
        String url="https://fakestoreapi.com/products/"+id;
        ProductResponseDTO prd=new ProductResponseDTO();

        // HttpEntity<ProductRequestDTO> requestEntity = new HttpEntity<>(productRequestDTO);
        try{
        // Perform the PATCH request and map the response to ProductResponseDTO
        ProductModel response = rest.patchForObject(
                url, productRequestDTO, ProductModel.class);
        if(response !=null){
               prd=responseMapping.ConvertProductModeltoProductResponseDTO(response);
        }
        return prd;
    }
    catch(Exception e){
            throw e;
    }
    }
    public ProductResponseDTO deleteProduct(int id) {
        String url="https://fakestoreapi.com/products/"+id;
              ProductResponseDTO prd=new ProductResponseDTO();
        ResponseEntity<ProductModel> pm=rest.exchange(url,HttpMethod.DELETE,null,ProductModel.class);
         if(pm.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            prd=responseMapping.ConvertProductModeltoProductResponseDTO(pm.getBody());
         }
         return prd;
    }




}
