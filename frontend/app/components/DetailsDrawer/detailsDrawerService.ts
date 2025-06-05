import {
  blankDetails,
  CurrentWeatherContext,
  type Details,
} from "#app-context/current-weather-context.js";
import { useContext, useState } from "react";

export interface DetailsDrawerService {
  details: Details;
}

export const useDetailsDrawerService = (): DetailsDrawerService => {
  const [details, setDetails] = useState<Details>(blankDetails);

  const {currentWeather} = useContext(CurrentWeatherContext)
  setDetails(currentWeather.details)

  return { details };
};
