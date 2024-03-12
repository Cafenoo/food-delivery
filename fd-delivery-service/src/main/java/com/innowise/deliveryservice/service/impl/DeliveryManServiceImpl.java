package com.innowise.deliveryservice.service.impl;

import com.innowise.deliveryservice.dto.DeliveryManDto;
import com.innowise.deliveryservice.mapper.DeliveryManMapper;
import com.innowise.deliveryservice.model.DeliveryMan;
import com.innowise.deliveryservice.repository.DeliveryManRepository;
import com.innowise.deliveryservice.service.DeliveryManService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeliveryManServiceImpl implements DeliveryManService {

  private final DeliveryManRepository deliveryManRepository;
  private final DeliveryManMapper deliveryManMapper;

  @Override
  @Transactional(readOnly = true)
  public DeliveryManDto getDeliveryMan(Long id) {
    DeliveryMan deliveryMan = deliveryManRepository
        .findById(id)
        .orElseThrow(EntityNotFoundException::new);
    return deliveryManMapper.toDto(deliveryMan);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<DeliveryManDto> getDeliveryManList(Integer pageNumber, Integer pageSize) {
    return deliveryManRepository
        .findAll(PageRequest.of(pageNumber, pageSize))
        .map(deliveryManMapper::toDto);
  }

  @Override
  @Transactional
  public DeliveryMan createDeliveryMan(DeliveryManDto deliveryManDto) {
    DeliveryMan deliveryMan = deliveryManMapper.toEntity(deliveryManDto);
    return deliveryManRepository.save(deliveryMan);
  }

  @Override
  @Transactional
  public void updateDeliveryMan(Long id, DeliveryManDto deliveryManDto) {
    getDeliveryMan(id);
    DeliveryMan convertedDeliveryMan = deliveryManMapper.toEntity(deliveryManDto);

    convertedDeliveryMan.setId(id);

    deliveryManRepository.save(convertedDeliveryMan);
  }

  @Override
  @Transactional
  public void deleteDeliveryMan(Long id) {
    getDeliveryMan(id);
    deliveryManRepository.deleteById(id);
  }
}
