import {
  blankVibe,
  CurrentWeatherContext,
  type Vibe,
} from "#app-context/current-weather-context.js";
import { useContext, useEffect, useState } from "react";

export interface VibeContainerService {
  vibe: Vibe;
}

export const useVibeContainerService = () => {
  const [vibe, setVibe] = useState(blankVibe);

  const { currentWeather } = useContext(CurrentWeatherContext);

  useEffect(() => setVibe(currentWeather.vibe), [currentWeather.vibe]);

  return { vibe };
};
