package com.innowise.restaurantservice.service.impl;

import com.innowise.restaurantservice.dto.RestaurantDto;
import com.innowise.restaurantservice.mapper.RestaurantMapper;
import com.innowise.restaurantservice.model.Restaurant;
import com.innowise.restaurantservice.repository.RestaurantRepository;
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
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final RestaurantMapper restaurantMapper;

  @Override
  @Transactional(readOnly = true)
  public Restaurant getRestaurant(Long id) {
    return restaurantRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  @Transactional(readOnly = true)
  public RestaurantDto getRestaurantDto(Long id) {
    return restaurantMapper.toDto(getRestaurant(id));
  }

  @Override
  @Transactional(readOnly = true)
  public List<Restaurant> getRestaurantList(Integer pageNumber, Integer pageSize) {
    return restaurantRepository.findAll(PageRequest.of(pageNumber, pageSize))
        .getContent();
  }

  @Override
  @Transactional(readOnly = true)
  public List<RestaurantDto> getRestaurantDtoList(Integer pageNumber, Integer pageSize) {
    return getRestaurantList(pageNumber, pageSize).stream()
        .map(restaurantMapper::toDto)
        .collect(Collectors.toList());
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
