import React, { useState } from "react";
import {
  CurrentWeatherContext,
  type AppState,
} from "./current-weather-context";

interface Props {
  children: React.ReactNode;
}

export const CurrentWeatherContextProvider: React.FC<Props> = ({
  children,
}) => {
  const [state, setState] = useState({});

  const updateState = (newState: Partial<AppState>) => {
    setState({ ...state, ...newState });
  };

  return (
    <CurrentWeatherContext.Provider value={{ ...state, updateState }}>
      {children}
    </CurrentWeatherContext.Provider>
  );
};
