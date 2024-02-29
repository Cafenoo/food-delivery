package com.innowise.restaurantservice.service;

import com.innowise.restaurantservice.dto.RestaurantDto;
import com.innowise.restaurantservice.model.Restaurant;
import java.util.List;

public interface RestaurantService {

  Restaurant getRestaurant(Long id);

  RestaurantDto getRestaurantDto(Long id);

  List<Restaurant> getRestaurantList(Integer pageNumber, Integer pageSize);

  List<RestaurantDto> getRestaurantDtoList(Integer pageNumber, Integer pageSize);

  Restaurant createRestaurant(RestaurantDto restaurantDto);

  void updateRestaurant(Long id, RestaurantDto restaurantDto);

  void deleteRestaurant(Long id);
}
