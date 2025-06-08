import React, { useState } from "react";
import {
  blankCurrentWeather,
  CurrentWeatherContext,
  type AppState,
} from "./current-weather-context";

interface Props {
  children: React.ReactNode;
}

export const CurrentWeatherContextProvider: React.FC<Props> = ({
  children,
}) => {
  const [state, setState] = useState({
    currentWeather: blankCurrentWeather,
  });

  const updateState = (newState: Partial<AppState>) => {
    setState({ ...state, ...newState });
  };

  return (
    <CurrentWeatherContext.Provider value={{ ...state, updateState }}>
      {children}
    </CurrentWeatherContext.Provider>
  );
};
