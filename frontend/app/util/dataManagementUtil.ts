import { useContext } from "react";
import { fetchCurrentWeather } from "~/api/weatherApi";
import { CurrentWeatherContext } from "~/app-context/current-weather-context";

const { updateState } = useContext(CurrentWeatherContext);

export const setCurrentWeather = async (query: string): Promise<void> => {
  const currentWeather = await fetchCurrentWeather(query);
  updateState({ currentWeather });
};
