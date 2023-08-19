package lzc.com.example.ecommerce.dao;

import lzc.com.example.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends JpaRepository<Product, Long> {
    // spring data jpa will automatically implement this method, it is the query method, start by findBy, quire by the field name
    // spring will expose the endpoint to the frontend, and the frontend call findByCategoryId
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
}
