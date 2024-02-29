package com.innowise.restaurantservice.service.impl;

import com.innowise.restaurantservice.dto.ProductDto;
import com.innowise.restaurantservice.mapper.ProductMapper;
import com.innowise.restaurantservice.model.Product;
import com.innowise.restaurantservice.model.Restaurant;
import com.innowise.restaurantservice.repository.ProductRepository;
import com.innowise.restaurantservice.service.ProductService;
import com.innowise.restaurantservice.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
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
  public Product getProduct(Long restaurantId, Long id) {
    return productRepository.findByRestaurantIdAndId(restaurantId, id)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  @Transactional(readOnly = true)
  public ProductDto getProductDto(Long restaurantId, Long id) {
    return productMapper.toDto(getProduct(restaurantId, id));
  }

  @Override
  @Transactional(readOnly = true)
  public List<Product> getProductList(Long restaurantId, Integer pageNumber, Integer pageSize) {
    return productRepository.findAllByRestaurantId(restaurantId, PageRequest.of(pageNumber, pageSize))
        .getContent();
  }

  @Override
  @Transactional(readOnly = true)
  public List<ProductDto> getProductDtoList(
      Long restaurantId, Integer pageNumber, Integer pageSize) {
    return getProductList(restaurantId, pageNumber, pageSize).stream()
        .map(productMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public Product createProduct(Long restaurantId, ProductDto productDto) {
    Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
    Product product = productMapper.toEntity(productDto);

    product.setRestaurant(restaurant);

    return productRepository.save(product);
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
