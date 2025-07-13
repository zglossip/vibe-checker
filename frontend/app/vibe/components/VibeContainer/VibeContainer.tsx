import React, { type ReactNode } from "react";

import { useVibeContainerService } from "#vibe/components/VibeContainer/vibeContainerService";
import styles from "./VibeContainer.module.css";

interface VibeContainerProps {
  children?: ReactNode;
}

const VibeContainer: React.FC<VibeContainerProps> = ({ children }) => {
  const { vibe } = useVibeContainerService();
  return (
    <div
      style={
        {
          "--primary-color": "#" + vibe.color,
          "--secondary-color": "#" + vibe.color2,
        } as React.CSSProperties
      }
      className={styles["vibe-container"]}
    >
      <div className={styles["vibe-container-text-wrapper"]}>
        <div className={styles["vibe-container-text"]}>{vibe.text}</div>
        {children}
      </div>
    </div>
  );
};

export default VibeContainer;
