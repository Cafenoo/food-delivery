package com.innowise.restaurantservice.service;

import com.innowise.restaurantservice.dto.ProductDto;
import com.innowise.restaurantservice.model.Product;
import java.util.List;

public interface ProductService {

  Product getProduct(Long restaurantId, Long id);

  ProductDto getProductDto(Long restaurantId, Long id);

  List<Product> getProductList(Long restaurantId, Integer pageNumber, Integer pageSize);

  List<ProductDto> getProductDtoList(Long restaurantId, Integer pageNumber, Integer pageSize);

  Product createProduct(Long restaurantId, ProductDto productDto);

  void updateProduct(Long restaurantId, Long id, ProductDto productDto);

  void deleteProduct(Long restaurantId, Long id);
}
