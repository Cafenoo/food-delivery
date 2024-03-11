package com.innowise.deliveryservice.config;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorRegistryConfig implements WebMvcConfigurer {

  private final List<HandlerInterceptor> applicationInterceptors;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    applicationInterceptors.forEach(registry::addInterceptor);
  }
}
