package com.innowise.restaurantservice.repository;

import com.innowise.restaurantservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {}
