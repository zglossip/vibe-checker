package com.zglossip.weather.infrastructure.dto;

import java.util.Objects;

public class ExternalConditionDTO {
  private String text;
  private String icon;
  private Short code;

  public ExternalConditionDTO() {

  }

  public String getText() {
    return text;
  }

  public String getIcon() {
    return icon;
  }

  public Short getCode() {
    return code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExternalConditionDTO that = (ExternalConditionDTO) o;
    return Objects.equals(text, that.text) && Objects.equals(icon, that.icon) && Objects.equals(code, that.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, icon, code);
  }

  @Override
  public String toString() {
    return "ExternalConditionDTO{" +
           "text='" + text + '\'' +
           ", icon='" + icon + '\'' +
           ", code=" + code +
           '}';
  }
}
