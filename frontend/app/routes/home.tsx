import React from "react";
import type { Route } from "./+types/home";
import { Vibe } from "../vibe/vibe";

// eslint-disable-next-line no-empty-pattern
export function meta({}: Route.MetaArgs) {
  return [
    { title: "Vibe Checker" },
    { name: "description", content: "Check out the vibe for a location!" },
  ];
}

export default function Home() {
  return <Vibe />;
}
