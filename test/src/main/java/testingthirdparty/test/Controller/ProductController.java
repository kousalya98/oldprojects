package testingthirdparty.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import testingthirdparty.test.DTO.ProductRequestDTO;
import testingthirdparty.test.DTO.ProductResponseDTO;
import testingthirdparty.test.Service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/Products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ProductResponseDTO getSigleProduct(@PathVariable int id) {
        return productService.getSigleProduct(id);
    }
    @GetMapping("/")
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping()
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.addProduct(productRequestDTO);
    }
    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct (@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.updateProduct(id,productRequestDTO);
        
    }
    @PatchMapping("/{id}")
    public ProductResponseDTO rewriteProduct(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO){
        return productService.rewriteProduct(id,productRequestDTO);
    }
    @DeleteMapping("/{id}")
    public ProductResponseDTO deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
    

    

 
    




}
