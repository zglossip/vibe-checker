import { useLocationService } from "#components/Location/locationService.mock";
import type { Meta, StoryObj } from "@storybook/react";
import { action } from "storybook/actions";

import Location from "./Location";

const meta: Meta<typeof Location> = {
  component: Location,
};

export default meta;
type Story = StoryObj<typeof Location>;

export const Default: Story = {
  async beforeEach() {
    useLocationService.mockReturnValue({handleClick: async () => action('click')(), handleInput: e => action('input')(e.target.value)});
  },
  args: {},
};
