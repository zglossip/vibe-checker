package com.zglossip.weather.infrastructure.client;

import com.zglossip.weather.infrastructure.dto.ExternalCurrentResponseDTO;

public interface IWeatherApiClient {

  ExternalCurrentResponseDTO getCurrent(String query);

}
