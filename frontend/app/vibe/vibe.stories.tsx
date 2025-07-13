import type { Meta, StoryObj } from "@storybook/react";
import { Vibe } from "./vibe";
import { useVibeContainerService } from "./components/VibeContainer/vibeContainerService.mock";
//TODO: I'll need to rename this view or something eventually
import { type Vibe as VibeType } from "#app-context/current-weather-context.js";

const meta: Meta<typeof Vibe> = {
  component: Vibe,
  async beforeEach(context) {
    const vibe = context.args.vibe as VibeType;
    useVibeContainerService.mockReturnValue({ vibe });
  },
};

export default meta;

type Story = StoryObj<typeof Vibe>;

export const Default: Story = {
  args: {
    vibe: {
      text: "This is a test vibe descriptor",
      color: "f033ff",
      color2: "33fff6",
    },
  },
};
