package com.innowise.deliveryservice.controller;

import static java.text.MessageFormat.format;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.innowise.deliveryservice.dto.DeliveryManDto;
import com.innowise.deliveryservice.model.DeliveryMan;
import com.innowise.deliveryservice.service.DeliveryManService;
import java.net.URI;
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
    DeliveryManDto DeliveryManDto = deliveryManService.getDeliveryMan(id);
    return ok(DeliveryManDto);
  }

  @GetMapping
  public ResponseEntity<Page<DeliveryManDto>> getDeliveryManList(
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize) {
    Page<DeliveryManDto> DeliveryManDtoList = deliveryManService.getDeliveryManList(
        pageNumber, pageSize);
    return ok(DeliveryManDtoList);
  }

  @PostMapping
  public ResponseEntity<Void> createDeliveryMan(@RequestBody DeliveryManDto DeliveryManDto) {
    DeliveryMan deliveryMan = deliveryManService.createDeliveryMan(DeliveryManDto);
    String location = format("/deliveries/{0}", deliveryMan.getId());
    URI locationUri = URI.create(location);
    return created(locationUri).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateDeliveryMan(
      @PathVariable Long id,
      @RequestBody DeliveryManDto DeliveryManDto) {
    deliveryManService.updateDeliveryMan(id, DeliveryManDto);
    return noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDeliveryMan(@PathVariable Long id) {
    deliveryManService.deleteDeliveryMan(id);
    return noContent().build();
  }
}
