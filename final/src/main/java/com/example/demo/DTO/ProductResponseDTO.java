package com.example.demo.DTO;
import com.example.demo.Model.Product;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductResponseDTO {
    private Product data;          // For responses returning a single User (e.g., login, signup)
    private ErrorDTO error;     // Error details (if any)
    

public ProductResponseDTO(Product data){
    this.data=data;
    this.error=null;
}
public ProductResponseDTO(ErrorDTO error){
    this.data=null;
    this.error=error;
}
public String toString(){
    return "ProductResponseDTO{" +
                "data=" + data +
                ", error=" + error +
                '}';
}

}