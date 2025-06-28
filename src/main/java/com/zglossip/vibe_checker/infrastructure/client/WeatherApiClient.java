package com.zglossip.vibe_checker.infrastructure.client;

import com.zglossip.vibe_checker.config.ApplicationProperties;
import com.zglossip.vibe_checker.infrastructure.dto.ExternalCurrentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Profile("!e2e")
public class WeatherApiClient implements IWeatherApiClient {

  private final WebClient externalWeatherApiClient;
  private final ApplicationProperties applicationProperties;

  @Autowired
  public WeatherApiClient(WebClient externalWeatherApiClient, ApplicationProperties applicationProperties) {
    this.externalWeatherApiClient = externalWeatherApiClient;
    this.applicationProperties = applicationProperties;
  }

  @Override
  public ExternalCurrentResponseDTO getCurrent(String query) {
    return externalWeatherApiClient.get()
        .uri("/current.json?q={query}&key={key}&aqi=no", query, applicationProperties.getApiKey())
        .retrieve()
        .bodyToMono(ExternalCurrentResponseDTO.class)
        .block();
  }
}
