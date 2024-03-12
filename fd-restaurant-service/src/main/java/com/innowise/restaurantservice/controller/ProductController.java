package com.innowise.restaurantservice.controller;

import static java.text.MessageFormat.format;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.innowise.restaurantservice.dto.ProductDto;
import com.innowise.restaurantservice.model.Product;
import com.innowise.restaurantservice.service.ProductService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<Page<ProductDto>> getProductList(
      @PathVariable Long restaurantId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize) {
    Page<ProductDto> productDtoList =
        productService.getProductList(restaurantId, pageNumber, pageSize);
    return ok(productDtoList);
  }

  @PostMapping
  public ResponseEntity<Void> createProduct(
      @PathVariable Long restaurantId,
      @RequestBody ProductDto productDto) {
    Product product = productService.createProduct(restaurantId, productDto);
    String location = format("/products/{0}", product.getId());
    return created(URI.create(location)).build();
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
