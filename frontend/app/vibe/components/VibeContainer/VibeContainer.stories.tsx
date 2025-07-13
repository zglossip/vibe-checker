import type { Meta, StoryObj } from "@storybook/react";
import React from "react";
import VibeContainer from "./VibeContainer";
import { useVibeContainerService } from "./vibeContainerService.mock";
import { type Vibe } from "#app-context/current-weather-context.js";

const meta: Meta<typeof VibeContainer> = {
  component: VibeContainer,
  argTypes: {
    color: { control: "color" },
    color2: { control: "color" },
  },
  async beforeEach(context) {
    const vibe = context.args as Vibe;
    useVibeContainerService.mockReturnValue({ vibe });
  },
};

export default meta;

type Story = StoryObj<typeof VibeContainer>;

export const Default: Story = {
  args: {
    text: "This is a test vibe descriptor\nI'm making sure to include a line break in here.",
    color: "f033ff",
    color2: "33fff6",
  },
};

export const WithChildren: Story = {
  args: Default.args,
  render: () => (
    <VibeContainer>
      <span>Here are some children!</span>
    </VibeContainer>
  ),
};
