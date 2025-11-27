package testingthirdparty.test.Mapping;

import org.springframework.stereotype.Component;

import testingthirdparty.test.DTO.ProductRequestDTO;
import testingthirdparty.test.Model.Product;

@Component
public class ProductRequestMapping {

    public Product convertProductRequstDTOToProduct(ProductRequestDTO productRequestDTO){
        Product pod=new Product();
        pod.setTitile(productRequestDTO.getTitile());
        pod.setPrice(productRequestDTO.getPrice());
        pod.setCategory(productRequestDTO.getCategory());
        pod.setDescription(productRequestDTO.getDescription());
        pod.setImage(productRequestDTO.getImage());
        return pod;
    }
 

}
