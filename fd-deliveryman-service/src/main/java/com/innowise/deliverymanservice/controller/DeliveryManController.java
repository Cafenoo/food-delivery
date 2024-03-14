package com.innowise.deliverymanservice.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.innowise.deliverymanservice.dto.DeliveryManDto;
import com.innowise.deliverymanservice.model.DeliveryMan;
import com.innowise.deliverymanservice.service.DeliveryManService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliverymen")
@RequiredArgsConstructor
public class DeliveryManController {

  private final DeliveryManService deliveryManService;

  @GetMapping("/{id}")
  public ResponseEntity<DeliveryManDto> getDeliveryMan(@PathVariable Long id) {
    DeliveryManDto deliveryManDto = deliveryManService.getDeliveryMan(id);
    return ok(deliveryManDto);
  }

  @GetMapping
  @PageableAsQueryParam
  public ResponseEntity<Page<DeliveryManDto>> getDeliveryManList(
      @PageableDefault(sort = "id") Pageable pageable) {
    Page<DeliveryManDto> deliveryManDtoList = deliveryManService.getDeliveryManList(pageable);
    return ok(deliveryManDtoList);
  }

  @PostMapping
  public ResponseEntity<DeliveryMan> createDeliveryMan(
      @RequestBody DeliveryManDto deliveryManDto) {
    DeliveryMan deliveryMan = deliveryManService.createDeliveryMan(deliveryManDto);
    return status(CREATED.value()).body(deliveryMan);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateDeliveryMan(
      @PathVariable Long id,
      @RequestBody DeliveryManDto deliveryManDto) {
    deliveryManService.updateDeliveryMan(id, deliveryManDto);
    return noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDeliveryMan(@PathVariable Long id) {
    deliveryManService.deleteDeliveryMan(id);
    return noContent().build();
  }
}
