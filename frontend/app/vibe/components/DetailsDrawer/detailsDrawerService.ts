import {
  blankDetails,
  CurrentWeatherContext,
  type Details,
} from "#app-context/current-weather-context.js";
import { useContext, useEffect, useState } from "react";

export interface DetailsDrawerService {
  details: Details;
}

export const useDetailsDrawerService = (): DetailsDrawerService => {
  const [details, setDetails] = useState<Details>(blankDetails);

  const { currentWeather } = useContext(CurrentWeatherContext);

  useEffect(() => setDetails(currentWeather.details), [currentWeather.details]);

  return { details };
};
