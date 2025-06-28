package com.zglossip.vibe_checker.infrastructure.dto;

import java.util.Objects;

public class ExternalCurrentResponseDTO {

  private ExternalLocationDTO location;
  private ExternalCurrentDTO current;

  public ExternalCurrentResponseDTO() {

  }

  public ExternalLocationDTO getLocation() {
    return location;
  }

  public void setLocation(ExternalLocationDTO location) {
    this.location = location;
  }

  public ExternalCurrentDTO getCurrent() {
    return current;
  }

  public void setCurrent(ExternalCurrentDTO current) {
    this.current = current;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExternalCurrentResponseDTO that = (ExternalCurrentResponseDTO) o;
    return Objects.equals(location, that.location) && Objects.equals(current, that.current);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, current);
  }

  @Override
  public String toString() {
    return "ExternalCurrentResponseDTO{" +
           "location=" + location +
           ", current=" + current +
           '}';
  }
}

