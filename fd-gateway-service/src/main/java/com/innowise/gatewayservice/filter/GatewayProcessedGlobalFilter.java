package com.innowise.gatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GatewayProcessedGlobalFilter implements GlobalFilter {

  private static final String GATEWAY_HEADER = "Fd-Gateway-Processed";
  private static final String GATEWAY_HEADER_VALUE = "true";

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest mutatedRequest = exchange.getRequest()
        .mutate()
        .header(GATEWAY_HEADER, GATEWAY_HEADER_VALUE)
        .build();

    ServerWebExchange mutatedExchange = exchange.mutate()
        .request(mutatedRequest)
        .build();

    return chain.filter(mutatedExchange);
  }
}
