package com.zglossip.vibe_checker.service;

import com.zglossip.vibe_checker.domain.CurrentWeather;
import com.zglossip.vibe_checker.domain.Details;
import com.zglossip.vibe_checker.infrastructure.client.IWeatherApiClient;
import com.zglossip.vibe_checker.infrastructure.translator.CurrentWeatherTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherService {

  private final IWeatherApiClient weatherApiClient;

  @Autowired
  public CurrentWeatherService(IWeatherApiClient weatherApiClient) {
    this.weatherApiClient = weatherApiClient;
  }

  public CurrentWeather getCurrentWeather(final String query) {
    Details details = CurrentWeatherTranslator.translate(weatherApiClient.getCurrent(query));

    return new CurrentWeather(details);
  }
}
