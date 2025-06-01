import React from "react";

import type { Preview } from "@storybook/react";
import { AppProvider } from "@toolpad/core";
import { CurrentWeatherContextProvider } from "../app/app-context/current-weather-context-provider";

const preview: Preview = {
  parameters: {
    controls: {
      matchers: {
        color: /(background|color)$/i,
        date: /Date$/i,
      },
    },
  },
  decorators: [
    (Story) => (
      <AppProvider>
        <CurrentWeatherContextProvider>
          <Story />
        </CurrentWeatherContextProvider>
      </AppProvider>
    ),
  ],
};

export default preview;
