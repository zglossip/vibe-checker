import { fn } from "storybook/test";
import * as actual from "./detailsDrawerService";

export * from "./detailsDrawerService";
export const useDetailsDrawerService = fn(
  actual.useDetailsDrawerService,
).mockName("useDetailsDrawerService");
