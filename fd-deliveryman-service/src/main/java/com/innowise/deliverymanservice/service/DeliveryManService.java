package com.innowise.deliverymanservice.service;

import com.innowise.deliverymanservice.dto.DeliveryManDto;
import com.innowise.deliverymanservice.model.DeliveryMan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryManService {

  DeliveryManDto getDeliveryMan(Long id);

  Page<DeliveryManDto> getDeliveryManList(Pageable pageable);

  DeliveryMan createDeliveryMan(DeliveryManDto deliveryManDto);

  void updateDeliveryMan(Long id, DeliveryManDto deliveryManDto);

  void deleteDeliveryMan(Long id);

  boolean existsById(Long id);
}
