package com.innowise.deliveryservice.service.impl;

import com.innowise.deliveryservice.repository.DeliveryManRepository;
import com.innowise.deliveryservice.dto.DeliveryManDto;
import com.innowise.deliveryservice.mapper.DeliveryManMapper;
import com.innowise.deliveryservice.model.DeliveryMan;
import com.innowise.deliveryservice.service.DeliveryManService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryManServiceImpl implements DeliveryManService {

  private final DeliveryManRepository deliveryManRepository;
  private final DeliveryManMapper deliveryManMapper;

  @Override
  public DeliveryMan getDeliveryMan(Long id) {
    return deliveryManRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public DeliveryManDto getDeliveryManDto(Long id) {
    return deliveryManMapper.toDto(getDeliveryMan(id));
  }

  @Override
  public List<DeliveryMan> getDeliveryManList(Integer pageNumber, Integer pageSize) {
    return deliveryManRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }

  @Override
  public List<DeliveryManDto> getDeliveryManDtoList(Integer pageNumber, Integer pageSize) {
    return getDeliveryManList(pageNumber, pageSize).stream()
        .map(deliveryManMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public DeliveryMan createDeliveryMan(DeliveryManDto deliveryManDto) {
    DeliveryMan deliveryMan = deliveryManMapper.toEntity(deliveryManDto);
    return deliveryManRepository.save(deliveryMan);
  }

  @Override
  public void updateDeliveryMan(Long id, DeliveryManDto deliveryManDto) {
    getDeliveryMan(id);
    DeliveryMan convertedDeliveryMan = deliveryManMapper.toEntity(deliveryManDto);

    convertedDeliveryMan.setId(id);

    deliveryManRepository.save(convertedDeliveryMan);
  }

  @Override
  public void deleteDeliveryMan(Long id) {
    getDeliveryMan(id);
    deliveryManRepository.deleteById(id);
  }
}
