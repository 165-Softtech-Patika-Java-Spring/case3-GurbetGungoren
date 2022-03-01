package softtech.service;

import softtech.dto.ProductDto;
import softtech.dto.ProductResponse;
import softtech.dto.UpdateProductDto;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductDto productDto);
    List<ProductResponse> getProductsList();
    ProductResponse getProductById(Long id);
    void deleteProductById(Long id);
    ProductResponse updateProductsPrice(UpdateProductDto updateProductDto);
}
