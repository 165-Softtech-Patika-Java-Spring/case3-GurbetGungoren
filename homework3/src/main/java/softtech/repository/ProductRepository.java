package softtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softtech.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
