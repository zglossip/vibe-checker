import {
  blankDetails,
  type Details,
} from "#app-context/current-weather-context.js";
import { useState } from "react";

export interface DetailsDrawerService {
  details: Details;
}

export const useDetailsDrawerService = (): DetailsDrawerService => {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [details, setDetails] = useState<Details>(blankDetails);

  //TODO: Set this up

  return { details };
};
