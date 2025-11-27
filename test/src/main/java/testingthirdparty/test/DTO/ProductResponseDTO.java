package testingthirdparty.test.DTO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ProductResponseDTO {
    private int id;
    private String titile;
    private int price;
    private String description;
    private String category;
    private String image;
}
