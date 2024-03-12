package com.innowise.deliveryservice.service;

import com.innowise.deliveryservice.dto.DeliveryManDto;
import com.innowise.deliveryservice.model.DeliveryMan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeliveryManService {

  DeliveryManDto getDeliveryMan(Long id);

  Page<DeliveryManDto> getDeliveryManList(Pageable pageable);

  DeliveryMan createDeliveryMan(DeliveryManDto deliveryManDto);

  void updateDeliveryMan(Long id, DeliveryManDto deliveryManDto);

  void deleteDeliveryMan(Long id);
}
