package com.zglossip.vibe_checker.domain;

import com.zglossip.vibe_checker.domain.enums.PrecipitationType;
import com.zglossip.vibe_checker.domain.enums.Severity;

import java.util.Objects;

public class Precipitation {

  private PrecipitationType type;
  private boolean thunder;
  private Severity severity;

  public Precipitation() {

  }

  public PrecipitationType getType() {
    return type;
  }

  public void setType(PrecipitationType type) {
    this.type = type;
  }

  public boolean isThunder() {
    return thunder;
  }

  public void setThunder(boolean thunder) {
    this.thunder = thunder;
  }

  public Severity getSeverity() {
    return severity;
  }

  public void setSeverity(Severity severity) {
    this.severity = severity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Precipitation that = (Precipitation) o;
    return thunder == that.thunder && type == that.type && severity == that.severity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, thunder, severity);
  }

  @Override
  public String toString() {
    return "PrecipitationDTO{" +
           "type=" + type +
           ", thunder=" + thunder +
           ", severity=" + severity +
           '}';
  }
}
