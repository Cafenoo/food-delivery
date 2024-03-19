package com.innowise.restaurantservice.specification;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

import com.innowise.restaurantservice.model.Product;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = PRIVATE)
public final class ProductSpecification {

  private static final String RESTAURANT_ID_FIELD = "restaurantId";

  public static Specification<Product> hasRestaurantId(Long restaurantId) {
    if (isNull(restaurantId)) {
      return null;
    }

    return (product, query, criteriaBuilder) ->
        criteriaBuilder.equal(product.get(RESTAURANT_ID_FIELD), restaurantId);
  }
}
