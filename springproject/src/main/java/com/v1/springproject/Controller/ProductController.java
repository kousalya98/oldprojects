package com.v1.springproject.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.v1.springproject.DTO.ProductRequestDTO;
import com.v1.springproject.DTO.ProductResponseDTO;
import com.v1.springproject.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/Products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
        
   @GetMapping("/{id}")
   public ProductResponseDTO getSingleProduct(@PathVariable int id) {
           ProductResponseDTO response= productService.getProductByid(id);
    return response;  
   }
   @GetMapping()
   public List<ProductResponseDTO> getAllProducts(){
    List<ProductResponseDTO> response=productService.getAllProducts();
    return response;
   }

  // @PostMapping()
   @RequestMapping( method = RequestMethod.POST,produces={"application/json","application/xml"})
   //@ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
       ProductResponseDTO response=productService.addProduct(productRequestDTO);
       return new ResponseEntity<>(response,HttpStatusCode.valueOf(201));
   }
    
  @PatchMapping("/{id}")
  public ProductResponseDTO updateProductdetail(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO){
    return productService.updateProductdetail(id, productRequestDTO );
  } 
  @DeleteMapping("/{id}")
  public ProductResponseDTO deleteProduct(@PathVariable int id){
    return productService.deleteProduct(id);
  }
   
}
 
