package com.innowise.restaurantservice.service.impl;

import static java.util.Optional.ofNullable;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

import com.innowise.restaurantservice.dto.OrderDto;
import com.innowise.restaurantservice.model.OrderStatus;
import com.innowise.restaurantservice.service.OrderService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private static final String ORDERS_URL = "http://order-service/api/orders";
  private static final String PAGE_NUMBER_PARAM = "pageNumber";
  private static final String PAGE_SIZE_PARAM = "pageSize";
  private static final String ORDER_STATUS_PARAM = "orderStatus";
  private static final String FD_GATEWAY_PROCESSED_HEADER = "Fd-Gateway-Processed";
  private static final String FD_GATEWAY_PROCESSED_HEADER_VALUE = "true";

  private final RestTemplate restTemplate;

  @Override
  public List<OrderDto> getOrderList(
      Long restaurantId,
      OrderStatus orderStatus,
      Integer pageNumber,
      Integer pageSize) {

    URI uri = fromHttpUrl(ORDERS_URL)
        .queryParam(PAGE_NUMBER_PARAM, pageNumber)
        .queryParam(PAGE_SIZE_PARAM, pageSize)
        .queryParamIfPresent(ORDER_STATUS_PARAM, ofNullable(orderStatus))
        .build()
        .toUri();

    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add(FD_GATEWAY_PROCESSED_HEADER, FD_GATEWAY_PROCESSED_HEADER_VALUE);

    ResponseEntity<List<OrderDto>> exchange = restTemplate.exchange(
        uri,
        HttpMethod.GET,
        new HttpEntity<>(headers),
        new ParameterizedTypeReference<>() {});

    return exchange.getBody();
  }
}
