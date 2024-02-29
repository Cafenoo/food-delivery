package com.innowise.restaurantservice.repository;

import com.innowise.restaurantservice.model.Product;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByRestaurantIdAndId(Long restaurantId, Long id);

  Page<Product> findAllByRestaurantId(Long restaurantId, Pageable pageable);
}
