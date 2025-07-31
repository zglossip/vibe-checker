import React, { type ReactNode } from "react";

import { useVibeContainerService } from "#vibe/components/VibeContainer/vibeContainerService";
import styles from "./VibeContainer.module.css";

interface VibeContainerProps {
  children?: ReactNode;
}

const VibeContainer: React.FC<VibeContainerProps> = ({ children }) => {
  const { vibe } = useVibeContainerService();

  const styleProperties = {
    "--primary-color": vibe.color,
    "--secondary-color": vibe.color2,
  } as React.CSSProperties;
  return (
    <div style={styleProperties} className={styles["vibe-container"]}>
      <div style={styleProperties} className={styles["vibe-background"]} />
      <div className={styles["vibe-text"]}>{vibe.text}</div>
      <div className={styles["vibe-children"]}>{children}</div>
    </div>
  );
};

export default VibeContainer;
