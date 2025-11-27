package com.example.demo.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.DTO.ErrorDTO;
import com.example.demo.DTO.ProductResponseDTO;

@ControllerAdvice
public class GolablExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductResponseDTO> handleProductNotFoundException(ProductNotFoundException ex){
        ErrorDTO error=new ErrorDTO(ex.getMessage(),HttpStatus.NOT_FOUND.value(),"ProductNotFoundException","Prodcut not present or not found in product List");
        ProductResponseDTO response=new ProductResponseDTO(error);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ProductsListNotFoundException.class)
    public ResponseEntity<ProductResponseDTO>handleProductsListNotFoundException(ProductsListNotFoundException ex){
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value() ,"ProductsListNotFoundException", "Productlist not present or List of product not found or empty");
        ProductResponseDTO response=new ProductResponseDTO(error);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ProductResponseDTO>handleGeneralException(GeneralException ex){
        ErrorDTO error=new ErrorDTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value() ,"General Exception", "General Exceoption, kindly reach later");
        ProductResponseDTO response=new ProductResponseDTO(error);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
