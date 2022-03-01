package softtech.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.dto.UpdateProductDto;
import softtech.model.ProductEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDaoImp implements ProductDao{
    private  final ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
    @Override
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductEntity updateProductPrice(Long id,BigDecimal newPrice) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productEntity.setProductPrice(newPrice);
        return productRepository.save(productEntity);
    }

}
