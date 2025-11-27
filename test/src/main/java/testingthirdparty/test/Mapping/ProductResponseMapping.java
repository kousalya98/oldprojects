package testingthirdparty.test.Mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import testingthirdparty.test.DTO.ProductResponseDTO;
import testingthirdparty.test.Model.Product;

@Component
public class ProductResponseMapping {
public ProductResponseDTO convertproducttopProductResponseDTO(Product product){
    ProductResponseDTO res=new ProductResponseDTO();
    res.setId(product.getId());
    res.setTitile(product.getTitile());
    res.setPrice(product.getPrice());
    res.setCategory(product.getCategory());
    res.setDescription(product.getDescription());
    res.setImage(product.getImage());
    return res;
}
public List<ProductResponseDTO> convertListofProductToProductResponseDTO(Product[] products){
    List<ProductResponseDTO> dto=new ArrayList<>();
    for(Product prod: products){
        ProductResponseDTO resp=new ProductResponseDTO();
        resp.setId(prod.getId());
        resp.setTitile(prod.getTitile());
        resp.setPrice(prod.getPrice());
        resp.setCategory(prod.getCategory());
        resp.setDescription(prod.getDescription());
        resp.setImage(prod.getImage());    
        dto.add(resp);
    }
    return dto;
} 
}
