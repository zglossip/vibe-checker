import type { CurrentWeather } from "#app-context/current-weather-context";
import { useNotifications } from "@toolpad/core";

export const useWeatherApi = () => {
  const notification = useNotifications();

  async function get<Type>(url: string): Promise<Type> {
    return fetch(url, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        if (!response.ok) {
          notification.show(`HTTP ${response.status}: ${response.statusText}`, {
            severity: "error",
          });
        } else {
          return response.json();
        }
      })
      .catch((error) => {
        notification.show(`HTTP ${error.status}: ${error.message}`, {
          severity: "error",
        });
        throw error;
      });
  }

  const fetchCurrentWeather = async (query: string): Promise<CurrentWeather> =>
    get<CurrentWeather>(
      `/vibe-checker/weather/current?query=${encodeURIComponent(query)}`,
    );

  return { fetchCurrentWeather };
};
