package com.innowise.orderservice.filter;

import static java.util.Objects.isNull;

import com.innowise.orderservice.exception.GatewayNotProcessedException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class GatewayProcessedFilter
    extends HttpFilter
    implements Filter {

  private static final String GATEWAY_HEADER = "Fd-Gateway-Processed";
  private static final String GATEWAY_HEADER_VALUE = "true";

  @Override
  protected void doFilter(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    String gatewayProcessedHeaderValue = request.getHeader(GATEWAY_HEADER);

    if (isNull(gatewayProcessedHeaderValue)
        || !gatewayProcessedHeaderValue.equals(GATEWAY_HEADER_VALUE)) {
      throw new GatewayNotProcessedException();
    }

    chain.doFilter(request, response);
  }
}
