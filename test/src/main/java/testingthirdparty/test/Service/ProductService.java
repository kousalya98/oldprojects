package testingthirdparty.test.Service;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import testingthirdparty.test.DTO.ProductRequestDTO;
import testingthirdparty.test.DTO.ProductResponseDTO;
import testingthirdparty.test.Mapping.ProductRequestMapping;
import testingthirdparty.test.Mapping.ProductResponseMapping;
import testingthirdparty.test.Model.Product;

@Service
public class ProductService {
       private ProductResponseMapping productResponseMapping;
       private ProductRequestMapping productRequestMapping;

       
          @Autowired
          public ProductService(ProductResponseMapping productResponseMapping,ProductRequestMapping productRequestMapping) {
        this.productResponseMapping = productResponseMapping;
        this.productRequestMapping=productRequestMapping;
    }

        RestTemplate restTemplate=new RestTemplate();

    public ProductResponseDTO getSigleProduct(int id) {
        
            String url="https://fakestoreapi.com/products"+id;
            ResponseEntity<Product> res=restTemplate.getForEntity(url,Product.class);
            ProductResponseDTO dto=new ProductResponseDTO();
            if(res.getStatusCode().equals(HttpStatus.OK)){
                dto=productResponseMapping.convertproducttopProductResponseDTO(res.getBody());
            }
            return dto;
    }

    public List<ProductResponseDTO> getAllProducts() {
        String url="https://fakestoreapi.com/products";
        ResponseEntity<Product[]> res=restTemplate.getForEntity(url,Product[].class);
        ProductResponseDTO dto=new ProductResponseDTO();
        List<ProductResponseDTO> dto1=new ArrayList<>();
        if(res.getStatusCode().equals(HttpStatus.OK)){
            dto1=productResponseMapping.convertListofProductToProductResponseDTO(res.getBody());
        }
        return dto1;
       }
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
            String url="https://fakestoreapi.com/products"+id;
            Product pod=productRequestMapping.convertProductRequstDTOToProduct(productRequestDTO);
            ResponseEntity<Product> res=restTemplate.postForEntity(url, pod, Product.class);
            ProductResponseDTO dto=new ProductResponseDTO();
            if(res.getStatusCode().equals(HttpStatus.OK)){
                    dto=productResponseMapping.convertproducttopProductResponseDTO(res.getBody());
            }
             return dto;      
    }
        public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        String url="https://fakestoreapi.com/products";
        Product pod=productRequestMapping.convertProductRequstDTOToProduct(productRequestDTO);
        ResponseEntity<Product> res=restTemplate.postForEntity(url, pod, Product.class);
        ProductResponseDTO resp=new ProductResponseDTO();
          if(res.getStatusCode().equals(HttpStatus.CREATED)){
            resp=productResponseMapping.convertproducttopProductResponseDTO(res.getBody());
          }
          return resp;
     }
        public ProductResponseDTO rewriteProduct(int id, ProductRequestDTO productRequestDTO) {
                String url="https://fakestoreapi.com/products"+id;
                Product pod=productRequestMapping.convertProductRequstDTOToProduct(productRequestDTO);
                Product res=restTemplate.patchForObject(url,pod,Product.class);
                ProductResponseDTO resp=new ProductResponseDTO();
                if(res!=null){
                    resp=productResponseMapping.convertproducttopProductResponseDTO(res);
                }
                return resp;
                }

        public ProductResponseDTO deleteProduct(int id) {
            String url="https://fakestoreapi.com/products"+id;
            ResponseEntity<Product> res=restTemplate.getForEntity(url, Product.class);
            ProductResponseDTO dto=new ProductResponseDTO();
            dto=productResponseMapping.convertproducttopProductResponseDTO(res.getBody());
            restTemplate.exchange(url,HttpMethod.DELETE, res, Product.class);
                          return dto;
        }
   
}
