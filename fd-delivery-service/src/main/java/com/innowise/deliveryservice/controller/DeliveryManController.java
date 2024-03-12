package com.innowise.deliveryservice.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.innowise.deliveryservice.dto.DeliveryManDto;
import com.innowise.deliveryservice.model.DeliveryMan;
import com.innowise.deliveryservice.service.DeliveryManService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryManController {

  private final DeliveryManService deliveryManService;

  @GetMapping("/{id}")
  public ResponseEntity<DeliveryManDto> getDeliveryMan(@PathVariable Long id) {
    DeliveryManDto deliveryManDto = deliveryManService.getDeliveryMan(id);
    return ok(deliveryManDto);
  }

  @GetMapping
  public ResponseEntity<Page<DeliveryManDto>> getDeliveryManList(
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize) {
    Page<DeliveryManDto> deliveryManDtoList = deliveryManService.getDeliveryManList(
        pageNumber, pageSize);
    return ok(deliveryManDtoList);
  }

  @PostMapping
  public ResponseEntity<DeliveryMan> createDeliveryMan(@RequestBody DeliveryManDto deliveryManDto) {
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
