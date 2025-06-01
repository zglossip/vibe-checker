import { useContext, useState } from "react";
import { useWeatherApi } from "~/api/weatherApi";
import { CurrentWeatherContext } from "~/app-context/current-weather-context";

export const useLocationService = () => {
  const { fetchCurrentWeather } = useWeatherApi();
  const { updateState } = useContext(CurrentWeatherContext);

  const [query, setQuery] = useState("");

  const handleClick = async (): Promise<void> => {
    const currentWeather = await fetchCurrentWeather(query);
    updateState({ currentWeather });
  };

  const handleInput = (e: React.ChangeEvent<HTMLInputElement>) =>
    setQuery(e.target.value);

  return { handleClick, handleInput };
};
