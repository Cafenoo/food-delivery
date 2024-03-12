package com.innowise.restaurantservice.service.impl;

import com.innowise.restaurantservice.dto.ProductDto;
import com.innowise.restaurantservice.mapper.ProductMapper;
import com.innowise.restaurantservice.model.Product;
import com.innowise.restaurantservice.model.Restaurant;
import com.innowise.restaurantservice.repository.ProductRepository;
import com.innowise.restaurantservice.service.ProductService;
import com.innowise.restaurantservice.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  private final RestaurantService restaurantService;

  @Override
  @Transactional(readOnly = true)
  public ProductDto getProduct(Long restaurantId, Long id) {
    Product product = productRepository
        .findByRestaurantIdAndId(restaurantId, id)
        .orElseThrow(EntityNotFoundException::new);
    return productMapper.toDto(product);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<ProductDto> getProductList(Long restaurantId, Integer pageNumber, Integer pageSize) {
    return productRepository
        .findAllByRestaurantId(restaurantId, PageRequest.of(pageNumber, pageSize))
        .map(productMapper::toDto);
  }

  @Override
  @Transactional
  public Product createProduct(Long restaurantId, ProductDto productDto) { // todo fix
//    Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
//    Product product = productMapper.toEntity(productDto);
//
//    product.setRestaurant(restaurant);
//
//    return productRepository.save(product);
    return null;
  }

  @Override
  @Transactional
  public void updateProduct(Long restaurantId, Long id, ProductDto productDto) {
    getProduct(restaurantId, id);
    Product convertedProduct = productMapper.toEntity(productDto);

    convertedProduct.setId(id);

    Restaurant restaurant = new Restaurant();
    restaurant.setId(restaurantId);
    convertedProduct.setRestaurant(restaurant);

    productRepository.save(convertedProduct);
  }

  @Override
  @Transactional
  public void deleteProduct(Long restaurantId, Long id) {
    getProduct(restaurantId, id);
    productRepository.deleteById(id);
  }
}
