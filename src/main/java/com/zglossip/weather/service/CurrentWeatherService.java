package com.zglossip.weather.service;

import com.zglossip.weather.domain.Details;
import com.zglossip.weather.infrastructure.client.IWeatherApiClient;
import com.zglossip.weather.infrastructure.translator.CurrentWeatherTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherService {

  private final IWeatherApiClient weatherApiClient;

  @Autowired
  public CurrentWeatherService(IWeatherApiClient weatherApiClient) {
    this.weatherApiClient = weatherApiClient;
  }

  public Details getCurrentWeather(final String query) {
    return CurrentWeatherTranslator.translate(weatherApiClient.getCurrent(query));
  }
}
