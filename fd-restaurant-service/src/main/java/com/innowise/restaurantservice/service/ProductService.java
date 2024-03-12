package com.innowise.restaurantservice.service;

import com.innowise.restaurantservice.dto.ProductDto;
import com.innowise.restaurantservice.model.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

  ProductDto getProduct(Long restaurantId, Long id);

  Page<ProductDto> getProductList(Long restaurantId, Integer pageNumber, Integer pageSize);

  Product createProduct(Long restaurantId, ProductDto productDto);

  void updateProduct(Long restaurantId, Long id, ProductDto productDto);

  void deleteProduct(Long restaurantId, Long id);
}
