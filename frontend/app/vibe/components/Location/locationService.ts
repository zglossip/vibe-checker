import { useContext, useState } from "react";
import { useWeatherApi } from "#api/weatherApi";
import {
  CurrentWeatherContext,
  type CurrentWeather,
} from "#app-context/current-weather-context";

export interface LocationService {
  handleClick: () => Promise<void>;
  handleInput: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

export const useLocationService = (): LocationService => {
  const { fetchCurrentWeather } = useWeatherApi();
  const { updateState } = useContext(CurrentWeatherContext);

  const [query, setQuery] = useState("");

  const handleClick = async (): Promise<void> => {
    const currentWeather: CurrentWeather = await fetchCurrentWeather(query);
    updateState({ currentWeather });
  };

  const handleInput = (e: React.ChangeEvent<HTMLInputElement>): void =>
    setQuery(e.target.value);

  return { handleClick, handleInput };
};
