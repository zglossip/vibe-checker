import DetailsDrawer from "./DetailsDrawer";
import type { Meta, StoryObj } from "@storybook/react";
import { useDetailsDrawerService } from "./detailsDrawerService.mock";
import {
  blankDetails,
  PRECIP_TYPE_NONE,
  PRECIP_TYPE_FOG,
  PRECIP_TYPE_RAIN,
  PRECIP_TYPE_MIXED,
  PRECIP_TYPE_SNOW,
  type PrecipitationType,
  NOT_AVAILABLE,
  PRECIP_SEV_EXTRA_HIGH,
  PRECIP_SEV_NONE,
  PRECIP_SEV_LOW,
  PRECIP_SEV_MEDIUM,
  PRECIP_SEV_HIGH,
  type PrecipitationSeverity,
} from "#app-context/current-weather-context.js";

const meta: Meta<typeof DetailsDrawer> = {
  component: DetailsDrawer,
};

export default meta;

type Story = StoryObj<typeof DetailsDrawer>;

export const Default: Story = {
  args: {
    precipitationSeverity: PRECIP_SEV_EXTRA_HIGH,
    precipitationThunder: false,
    precipitationType: PRECIP_TYPE_RAIN,
  },
  argTypes: {
    precipitationSeverity: {
      control: { type: "select" },
      options: [
        PRECIP_SEV_NONE,
        PRECIP_SEV_LOW,
        PRECIP_SEV_MEDIUM,
        PRECIP_SEV_HIGH,
        PRECIP_SEV_EXTRA_HIGH,
        NOT_AVAILABLE,
      ],
    },
    precipitationThunder: {
      control: { type: "select" },
      options: [true, false],
    },
    precipitationType: {
      control: { type: "select" },
      options: [
        PRECIP_TYPE_NONE,
        PRECIP_TYPE_FOG,
        PRECIP_TYPE_RAIN,
        PRECIP_TYPE_MIXED,
        PRECIP_TYPE_SNOW,
        NOT_AVAILABLE,
      ],
    },
  },
  async beforeEach(context) {
    const args = context.args as {
      precipitationSeverity: PrecipitationSeverity;
      precipitationThunder: boolean;
      precipitationType: PrecipitationType;
    };

    useDetailsDrawerService.mockReturnValue({
      details: {
        temperature: 74,
        airPressure: 50,
        cloud: 50,
        humidity: 35,
        precipitation: {
          severity: args.precipitationSeverity,
          thunder: args.precipitationThunder,
          type: args.precipitationType,
        },
        wind: 20,
      },
    });
  },
};

export const NoValue: Story = {
  async beforeEach() {
    useDetailsDrawerService.mockReturnValue({ details: blankDetails });
  },
};
