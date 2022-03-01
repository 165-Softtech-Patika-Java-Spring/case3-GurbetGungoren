package softtech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.converter.ProductConverter;
import softtech.dto.ProductDto;
import softtech.dto.ProductResponse;
import softtech.dto.UpdateProductDto;
import softtech.model.ProductEntity;
import softtech.repository.ProductDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private  final ProductDao productDao;
    private final ProductConverter productConverter;
    @Override
    public ProductResponse createProduct(ProductDto productDto) {
        ProductEntity product=productDao.createProduct(productConverter.convertToProduct(productDto));
        return productConverter.convertToProductResponse(product);
    }

    @Override
    public List<ProductResponse> getProductsList() {
        return productDao.getAllProducts().stream()
                .map(productConverter::convertToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        ProductEntity product = productDao.getProductById(id);
        return productConverter.convertToProductResponse(product);
    }
    @Override
    public void deleteProductById(Long id) {
        productDao.deleteProductById(id);
    }

    @Override
    public ProductResponse updateProductsPrice(UpdateProductDto updateProductDto) {
        System.out.println(updateProductDto.getNewPrice());
        ProductEntity updatedProduct = productDao.updateProductPrice(updateProductDto.getId(), updateProductDto.getNewPrice());
        return productConverter.convertToProductResponse(updatedProduct);
    }


}
