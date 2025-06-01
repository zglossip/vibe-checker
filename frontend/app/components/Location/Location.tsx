import React, { useContext, useState } from "react";
import { FormControl, OutlinedInput, IconButton } from "@mui/material";
import MagnifyingGlassIcon from "@mui/icons-material/Search";
import { CurrentWeatherContext } from "~/app-context/current-weather-context";
import { useWeatherApi } from "~/api/weatherApi";

const Location: React.FC = () => {
  const { fetchCurrentWeather } = useWeatherApi();
  const { updateState } = useContext(CurrentWeatherContext);

  const [query, setQuery] = useState("");

  const handleClick = async (): Promise<void> => {
    const currentWeather = await fetchCurrentWeather(query);
    updateState({ currentWeather });
  };

  const handleInput = (e: React.ChangeEvent<HTMLInputElement>) =>
    setQuery(e.target.value);

  const StartAdornment: React.FC = () => {
    return (
      <IconButton onClick={handleClick}>
        <MagnifyingGlassIcon />
      </IconButton>
    );
  };

  return (
    <FormControl>
      <OutlinedInput endAdornment={<StartAdornment />} onInput={handleInput} />
    </FormControl>
  );
};

export default Location;
