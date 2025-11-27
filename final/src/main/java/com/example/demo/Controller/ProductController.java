package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.Service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/{id}")
    public ProductResponseDTO getMethodName(@PathVariable int id) {
        return productService.getSingleProduct(id);
    }
    @GetMapping("/")
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    
    

}
