package softtech.converter;

import org.springframework.stereotype.Service;
import softtech.dto.ProductDto;
import softtech.dto.ProductResponse;
import softtech.model.ProductEntity;

@Service
public class ProductConverter {
    public ProductEntity convertToProduct(ProductDto productDto){
        ProductEntity product=new ProductEntity();
        product.setId(product.getId());
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        return product;
    }
    public ProductResponse convertToProductResponse(ProductEntity productEntity){
        ProductResponse productResponse =new ProductResponse();
        productResponse.setId(productEntity.getId());
        productResponse.setProductName(productEntity.getProductName());
        productResponse.setProductPrice(productEntity.getProductPrice());
        return productResponse;
    }
}

