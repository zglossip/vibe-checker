import React from "react";
import Location from "./components/Location/Location";
import VibeContainer from "./components/VibeContainer/VibeContainer";
import DetailsDrawer from "./components/DetailsDrawer/DetailsDrawer";
import { Box } from "@mui/material";

export function Vibe() {
  return (
    <main className="px-5 flex items-right">
      <VibeContainer>
        <Box sx={{ p: 2 }}>
          <Location />
        </Box>
        <DetailsDrawer />
      </VibeContainer>
    </main>
  );
}
