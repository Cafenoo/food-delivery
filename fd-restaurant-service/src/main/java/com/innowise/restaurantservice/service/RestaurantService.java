package com.innowise.restaurantservice.service;

import com.innowise.restaurantservice.dto.RestaurantDto;
import com.innowise.restaurantservice.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantService {

  RestaurantDto getRestaurant(Long id);

  Page<RestaurantDto> getRestaurantList(Pageable pageable);

  Restaurant createRestaurant(RestaurantDto restaurantDto);

  void updateRestaurant(Long id, RestaurantDto restaurantDto);

  void deleteRestaurant(Long id);
}
