package com.innowise.deliverymanservice.service.impl;

import com.innowise.deliverymanservice.dto.DeliveryManDto;
import com.innowise.deliverymanservice.mapper.DeliveryManMapper;
import com.innowise.deliverymanservice.model.DeliveryMan;
import com.innowise.deliverymanservice.repository.DeliveryManRepository;
import com.innowise.deliverymanservice.service.DeliveryManService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    DeliveryMan deliveryMan = deliveryManRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);
    return deliveryManMapper.toDto(deliveryMan);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<DeliveryManDto> getDeliveryManList(Pageable pageable) {
    return deliveryManRepository.findAll(pageable)
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
    if (!existsById(id)) {
      throw new EntityNotFoundException();
    }

    DeliveryMan convertedDeliveryMan = deliveryManMapper.toEntity(deliveryManDto);
    convertedDeliveryMan.setId(id);

    deliveryManRepository.save(convertedDeliveryMan);
  }

  @Override
  @Transactional
  public void deleteDeliveryMan(Long id) {
    if (!existsById(id)) {
      throw new EntityNotFoundException();
    }

    deliveryManRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return deliveryManRepository.findById(id)
        .isPresent();
  }
}
