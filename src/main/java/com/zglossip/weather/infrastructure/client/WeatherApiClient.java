package com.zglossip.weather.infrastructure.client;

import com.zglossip.weather.infrastructure.dto.ExternalCurrentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Profile("!e2e")
public class WeatherApiClient implements IWeatherApiClient {

  private final WebClient weatherApiClient;

  @Autowired
  public WeatherApiClient(WebClient weatherApiClient) {
    this.weatherApiClient = weatherApiClient;
  }

  @Override
  public ExternalCurrentResponseDTO getCurrent(String query) {
    return weatherApiClient.get()
        .uri("/current.json/q={query}", query)
        .retrieve()
        .bodyToMono(ExternalCurrentResponseDTO.class)
        .block();
  }
}
