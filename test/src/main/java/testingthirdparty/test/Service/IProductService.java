package testingthirdparty.test.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import testingthirdparty.test.DTO.ProductRequestDTO;
import testingthirdparty.test.DTO.ProductResponseDTO;

@Component
public interface IProductService {
    public ProductResponseDTO getSigleProduct(int id);
    public List<ProductResponseDTO> getAllProducts();
     public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO);
     public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);
     public ProductResponseDTO rewriteProduct(int id, ProductRequestDTO productRequestDTO);
     public ProductResponseDTO deleteProduct(int id);

}
