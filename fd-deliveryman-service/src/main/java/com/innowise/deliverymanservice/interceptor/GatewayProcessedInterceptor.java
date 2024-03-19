package com.innowise.deliverymanservice.interceptor;

import static java.util.Objects.isNull;

import com.innowise.deliverymanservice.exception.GatewayNotProcessedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class GatewayProcessedInterceptor implements HandlerInterceptor {

  private static final String GATEWAY_HEADER = "Fd-Gateway-Processed";
  private static final String GATEWAY_HEADER_VALUE = "true";

  @Override
  public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler) {

    if (isHeaderInvalid(request.getHeader(GATEWAY_HEADER))) {
      throw new GatewayNotProcessedException();
    }

    return true;
  }

  private boolean isHeaderInvalid(String headerValue) {
    return isNull(headerValue) || !headerValue.equals(GATEWAY_HEADER_VALUE);
  }
}
