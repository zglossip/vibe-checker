package com.zglossip.weather.controller;

import com.zglossip.weather.dto.CurrentWeatherDTO;
import com.zglossip.weather.service.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/weather")
public class WeatherController {

  private final CurrentWeatherService currentWeatherService;

  @Autowired
  public WeatherController(CurrentWeatherService currentWeatherService) {
    this.currentWeatherService = currentWeatherService;
  }

  @GetMapping(path = "/current")
  public CurrentWeatherDTO getCurrentWeather(@RequestParam String query) {
    return currentWeatherService.getCurrentWeather(query);
  }

}
