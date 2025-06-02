import React from "react";

export const NOT_AVAILABLE = "N/A" as const;
const DEFAULT_COLOR = "000000" as const;

export const PRECIP_TYPE_NONE = "NONE" as const;
export const PRECIP_TYPE_FOG = "FOG" as const;
export const PRECIP_TYPE_RAIN = "RAIN" as const;
export const PRECIP_TYPE_MIXED = "MIXED" as const;
export const PRECIP_TYPE_SNOW = "SNOW" as const;

export type PrecipitationType =
  | typeof PRECIP_TYPE_NONE
  | typeof PRECIP_TYPE_FOG
  | typeof PRECIP_TYPE_RAIN
  | typeof PRECIP_TYPE_MIXED
  | typeof PRECIP_TYPE_SNOW
  | typeof NOT_AVAILABLE;

export const PRECIP_SEV_NONE = "NONE" as const;
export const PRECIP_SEV_LOW = "LOW" as const;
export const PRECIP_SEV_MEDIUM = "MEDIUM" as const;
export const PRECIP_SEV_HIGH = "HIGH" as const;
export const PRECIP_SEV_EXTRA_HIGH = "EXTRA_HIGH" as const;

export type PrecipitationSeverity =
  | typeof PRECIP_SEV_NONE
  | typeof PRECIP_SEV_LOW
  | typeof PRECIP_SEV_MEDIUM
  | typeof PRECIP_SEV_HIGH
  | typeof PRECIP_SEV_EXTRA_HIGH
  | typeof NOT_AVAILABLE;

type NotAvailableNumber = number | typeof NOT_AVAILABLE;
type NotAvailableBoolean = boolean | typeof NOT_AVAILABLE;

export interface Vibe {
  color: string;
  color2: string;
  text: string;
}

export const blankVibe: Vibe = {
  color: DEFAULT_COLOR,
  color2: DEFAULT_COLOR,
  text: NOT_AVAILABLE,
};

export interface Precipitation {
  type: PrecipitationType;
  thunder: NotAvailableBoolean;
  severity: PrecipitationSeverity;
}

export const blankPrecipitation: Precipitation = {
  type: NOT_AVAILABLE,
  thunder: NOT_AVAILABLE,
  severity: NOT_AVAILABLE,
};

export interface Details {
  temperature: NotAvailableNumber;
  precipitation: Precipitation;
  humidity: NotAvailableNumber;
  wind: NotAvailableNumber;
  airPressure: NotAvailableNumber;
  cloud: NotAvailableNumber;
}

export const blankDetails: Details = {
  temperature: NOT_AVAILABLE,
  precipitation: blankPrecipitation,
  humidity: NOT_AVAILABLE,
  wind: NOT_AVAILABLE,
  airPressure: NOT_AVAILABLE,
  cloud: NOT_AVAILABLE,
};

export interface CurrentWeather {
  vibe: Vibe;
  details: Details;
}

export const blankCurrentWeather: CurrentWeather = {
  vibe: blankVibe,
  details: blankDetails,
};

export interface AppState {
  currentWeather: CurrentWeather;
  updateState: (newState: Partial<AppState>) => void;
}

const defaultState: AppState = {
  currentWeather: blankCurrentWeather,
  updateState: () => {
    console.warn("updateState function not provided");
  },
};

export const CurrentWeatherContext =
  React.createContext<AppState>(defaultState);
