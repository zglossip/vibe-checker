import { fn } from "storybook/test";
import * as actual from "./vibeContainerService";

export * from "./vibeContainerService";
export const useVibeContainerService = fn(
  actual.useVibeContainerService,
).mockName("useVibeContainerService");
