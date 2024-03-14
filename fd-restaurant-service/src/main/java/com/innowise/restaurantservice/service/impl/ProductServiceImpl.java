package com.innowise.restaurantservice.service.impl;

import static java.util.Objects.nonNull;

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
import org.springframework.data.domain.Pageable;
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
  public ProductDto getProduct(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);
    return productMapper.toDto(product);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<ProductDto> getProductList(Long restaurantId, Pageable pageable) {
    if (nonNull(restaurantId)) {
      return productRepository.findAllByRestaurantId(restaurantId, pageable)
          .map(productMapper::toDto);
    }

    return productRepository.findAll(pageable)
        .map(productMapper::toDto);
  }

  @Override
  @Transactional
  public Product createProduct(Long restaurantId, ProductDto productDto) {
    if (!restaurantService.existsById(restaurantId)) {
      throw new EntityNotFoundException();
    }

    Product product = productMapper.toEntity(productDto);

    Restaurant restaurant = new Restaurant();
    restaurant.setId(restaurantId);
    product.setRestaurant(restaurant);

    return productRepository.save(product);
  }

  @Override
  @Transactional
  public void updateProduct(Long id, ProductDto productDto) {
    Product fetchedProduct = productRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);

    Product convertedProduct = productMapper.toEntity(productDto);
    convertedProduct.setId(id);

    convertedProduct.setRestaurant(fetchedProduct.getRestaurant());

    productRepository.save(convertedProduct);
  }

  @Override
  @Transactional
  public void deleteProduct(Long id) {
    if (!existsById(id)) {
      throw new EntityNotFoundException();
    }

    productRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return productRepository.findById(id)
        .isPresent();
  }
}
