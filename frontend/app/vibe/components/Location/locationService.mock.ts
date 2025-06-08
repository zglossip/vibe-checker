import { fn } from "storybook/test";
import * as actual from "./locationService";

export * from "./locationService";
export const useLocationService = fn(actual.useLocationService).mockName(
  "useLocationService",
);
