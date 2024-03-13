package com.innowise.restaurantservice.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.innowise.restaurantservice.dto.ProductDto;
import com.innowise.restaurantservice.model.Product;
import com.innowise.restaurantservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProduct(
      @PathVariable Long restaurantId,
      @PathVariable Long id) {
    ProductDto product = productService.getProduct(restaurantId, id);
    return ok(product);
  }

  @GetMapping
  @PageableAsQueryParam
  public ResponseEntity<Page<ProductDto>> getProductList(
      @PathVariable Long restaurantId,
      @PageableDefault(sort = "id") Pageable pageable) {
    Page<ProductDto> productDtoList = productService.getProductList(restaurantId, pageable);
    return ok(productDtoList);
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(
      @PathVariable Long restaurantId,
      @RequestBody ProductDto productDto) {
    Product product = productService.createProduct(restaurantId, productDto);
    return status(CREATED.value()).body(product);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateProduct(
      @PathVariable Long restaurantId,
      @PathVariable Long id,
      @RequestBody ProductDto productDto) {
    productService.updateProduct(restaurantId, id, productDto);
    return noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(
      @PathVariable Long restaurantId,
      @PathVariable Long id) {
    productService.deleteProduct(restaurantId, id);
    return noContent().build();
  }
}
