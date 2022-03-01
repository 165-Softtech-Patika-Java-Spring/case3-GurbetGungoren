package softtech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softtech.dto.ProductDto;
import softtech.dto.UpdateProductDto;
import softtech.service.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/api/v1/products")
    public ResponseEntity createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }
    @GetMapping("/api/v1/productsList")
    public ResponseEntity getProductsList(){
        return ResponseEntity.ok(productService.getProductsList());
    }
    @GetMapping("/api/v1/product/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @DeleteMapping("/api/v1/deleteProduct/{id}")
    public void  deleteProduct(@PathVariable Long id){
         productService.deleteProductById(id);
    }

    @PutMapping("/api/v1/update")
    public ResponseEntity updateProduct(@RequestBody UpdateProductDto updateProductDto){
        return ResponseEntity.ok(productService.updateProductsPrice(updateProductDto));
    }
}
