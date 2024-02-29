package com.innowise.deliveryservice.service;

import com.innowise.deliveryservice.dto.DeliveryManDto;
import com.innowise.deliveryservice.model.DeliveryMan;
import java.util.List;

public interface DeliveryManService {

  DeliveryMan getDeliveryMan(Long id);

  DeliveryManDto getDeliveryManDto(Long id);

  List<DeliveryMan> getDeliveryManList(Integer pageNumber, Integer pageSize);

  List<DeliveryManDto> getDeliveryManDtoList(Integer pageNumber, Integer pageSize);

  DeliveryMan createDeliveryMan(DeliveryManDto deliveryManDto);

  void updateDeliveryMan(Long id, DeliveryManDto deliveryManDto);

  void deleteDeliveryMan(Long id);
}
