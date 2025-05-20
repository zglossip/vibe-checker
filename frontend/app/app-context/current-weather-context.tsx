import React from "react";

export interface Vibe {
    color: string;
    color2: string;
    text: string;
}

export interface Precipitation {
    type: string;
    thunder: boolean;
    severity: string;
}

export interface Details {
    temperature: number;
    precipitation: Precipitation;
    humidity: number;
    wind: number;
    airPressure: number;
    cloud: number;
}

export interface CurrentWeather {
    vibe?: Vibe;
    details?: Details;
}

export interface AppState {
    currentWeather?: CurrentWeather;
    updateState: (newState: Partial<AppState>) => void;
}

const defaultState: AppState = {
    currentWeather: {},
    updateState: () => {console.warn("updateState function not provided");},
};

export const CurrentWeatherContext = React.createContext<AppState>(defaultState);