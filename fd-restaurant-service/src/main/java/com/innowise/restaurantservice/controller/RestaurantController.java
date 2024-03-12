package com.innowise.restaurantservice.controller;

import static java.text.MessageFormat.format;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.innowise.restaurantservice.dto.RestaurantDto;
import com.innowise.restaurantservice.model.Restaurant;
import com.innowise.restaurantservice.service.RestaurantService;
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
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("/{id}")
  public ResponseEntity<RestaurantDto> getRestaurant(
      @PathVariable Long id) {
    RestaurantDto restaurantDto = restaurantService.getRestaurant(id);
    return ok(restaurantDto);
  }

  @GetMapping
  public ResponseEntity<Page<RestaurantDto>> getRestaurantList(
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize) {
    Page<RestaurantDto> restaurantDtoList =
        restaurantService.getRestaurantList(pageNumber, pageSize);
    return ok(restaurantDtoList);
  }

  @PostMapping
  public ResponseEntity<Void> createRestaurant(
      @RequestBody RestaurantDto restaurantDto) {
    Restaurant restaurant = restaurantService.createRestaurant(restaurantDto);
    String location = format("/customer/{0}", restaurant.getId());
    return created(URI.create(location)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateRestaurant(
      @PathVariable Long id,
      @RequestBody RestaurantDto restaurantDto) {
    restaurantService.updateRestaurant(id, restaurantDto);
    return noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRestaurant(
      @PathVariable Long id) {
    restaurantService.deleteRestaurant(id);
    return noContent().build();
  }
}
