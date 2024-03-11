package com.innowise.customerservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InterceptorRegistryConfig implements WebMvcConfigurer {

  private final List<HandlerInterceptor> applicationInterceptors;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    applicationInterceptors.forEach(registry::addInterceptor);
  }
}
