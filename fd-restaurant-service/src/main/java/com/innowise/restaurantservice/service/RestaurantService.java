package com.innowise.restaurantservice.service;

import com.innowise.restaurantservice.dto.RestaurantDto;
import com.innowise.restaurantservice.model.Restaurant;
import org.springframework.data.domain.Page;

public interface RestaurantService {

  RestaurantDto getRestaurant(Long id);

  Page<RestaurantDto> getRestaurantList(Integer pageNumber, Integer pageSize);

  Restaurant createRestaurant(RestaurantDto restaurantDto);

  void updateRestaurant(Long id, RestaurantDto restaurantDto);

  void deleteRestaurant(Long id);
}
