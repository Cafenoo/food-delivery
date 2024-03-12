package com.innowise.restaurantservice.service.impl;

import com.innowise.restaurantservice.dto.RestaurantDto;
import com.innowise.restaurantservice.mapper.RestaurantMapper;
import com.innowise.restaurantservice.model.Restaurant;
import com.innowise.restaurantservice.repository.RestaurantRepository;
import com.innowise.restaurantservice.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final RestaurantMapper restaurantMapper;

  @Override
  @Transactional(readOnly = true)
  public RestaurantDto getRestaurant(Long id) {
    Restaurant restaurant = restaurantRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);
    return restaurantMapper.toDto(restaurant);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<RestaurantDto> getRestaurantList(Pageable pageable) {
    return restaurantRepository.findAll(pageable)
        .map(restaurantMapper::toDto);
  }

  @Override
  @Transactional
  public Restaurant createRestaurant(RestaurantDto restaurantDto) {
    Restaurant restaurant = restaurantMapper.toEntity(restaurantDto);
    return restaurantRepository.save(restaurant);
  }

  @Override
  @Transactional
  public void updateRestaurant(Long id, RestaurantDto restaurantDto) {
    getRestaurant(id);
    Restaurant convertedRestaurant = restaurantMapper.toEntity(restaurantDto);

    convertedRestaurant.setId(id);

    restaurantRepository.save(convertedRestaurant);
  }

  @Override
  @Transactional
  public void deleteRestaurant(Long id) {
    getRestaurant(id);
    restaurantRepository.deleteById(id);
  }
}
