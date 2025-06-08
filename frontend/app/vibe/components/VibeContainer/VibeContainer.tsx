import React from "react";

import { Box } from "@mui/material";
import { useVibeContainerService } from "#vibe/components/VibeContainer/vibeContainerService";
import styles from "./VibeContainer.module.css";

const VibeContainer: React.FC = () => {
  const { vibe } = useVibeContainerService();
  return (
    <Box
      style={
        {
          "--primary-color": "#" + vibe.color,
          "--secondary-color": "#" + vibe.color2,
        } as React.CSSProperties
      }
      className={styles["vibe-container"]}
    >
      <p className={styles["vibe-container-text"]}>{vibe.text}</p>
    </Box>
  );
};

export default VibeContainer;
