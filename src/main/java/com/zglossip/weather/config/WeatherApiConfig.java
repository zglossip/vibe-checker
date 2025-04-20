package com.zglossip.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WeatherApiConfig {

  @Bean
  public WebClient weatherApiClient() {
    return WebClient.builder().baseUrl("http://api.weatherapi.com/v1").build();
  }
}
