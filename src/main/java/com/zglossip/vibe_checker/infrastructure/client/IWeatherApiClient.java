package com.zglossip.vibe_checker.infrastructure.client;

import com.zglossip.vibe_checker.infrastructure.dto.ExternalCurrentResponseDTO;

public interface IWeatherApiClient {

  ExternalCurrentResponseDTO getCurrent(String query);

}
