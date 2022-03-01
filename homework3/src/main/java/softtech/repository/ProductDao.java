package softtech.repository;

import softtech.model.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao {
    ProductEntity createProduct(ProductEntity productEntity);
    List<ProductEntity> getAllProducts();
    ProductEntity getProductById(Long id);
    void deleteProductById(Long id);
    ProductEntity updateProductPrice(Long id, BigDecimal newPrice);

}
