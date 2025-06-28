package com.zglossip.vibe_checker.infrastructure.dto;

import java.util.Objects;

public class ExternalLocationDTO {

  private String name;
  private String region;
  private Double lat;
  private Double lon;
  private String tz_id;
  private Integer localtime_epoch;
  private String localtime;

  public ExternalLocationDTO() {

  }

  public String getName() {
    return name;
  }

  public String getRegion() {
    return region;
  }

  public Double getLat() {
    return lat;
  }

  public Double getLon() {
    return lon;
  }

  public String getTz_id() {
    return tz_id;
  }

  public Integer getLocaltime_epoch() {
    return localtime_epoch;
  }

  public String getLocaltime() {
    return localtime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExternalLocationDTO that = (ExternalLocationDTO) o;
    return Objects.equals(name, that.name) && Objects.equals(region, that.region) && Objects.equals(lat, that.lat) && Objects.equals(lon, that.lon) && Objects.equals(tz_id, that.tz_id) && Objects.equals(localtime_epoch, that.localtime_epoch) && Objects.equals(localtime, that.localtime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, region, lat, lon, tz_id, localtime_epoch, localtime);
  }

  @Override
  public String toString() {
    return "ExternalLocationDTO{" +
           "name='" + name + '\'' +
           ", region='" + region + '\'' +
           ", lat=" + lat +
           ", lon=" + lon +
           ", tz_id='" + tz_id + '\'' +
           ", localtime_epoch=" + localtime_epoch +
           ", localtime='" + localtime + '\'' +
           '}';
  }
}
