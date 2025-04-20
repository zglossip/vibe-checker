package com.zglossip.weather.infrastructure.dto;

import java.util.Objects;

public class ExternalCurrentDTO {

  private Integer last_updated_epoch;
  private String last_updated;
  private Double temp_c;
  private Double temp_f;
  private Short is_day;
  private ExternalConditionDTO condition;
  private Double wind_mph;
  private Double wind_kph;
  private Short wind_degree;
  private String wind_dir;
  private Double pressure_mb;
  private Double pressure_in;
  private Double precip_mm;
  private Double precip_in;
  private Short humidity;
  private Short cloud;
  private Double feelslike_c;
  private Double feelslike_f;
  private Double windchill_c;
  private Double windchill_f;
  private Double heatindex_c;
  private Double heatindex_f;
  private Double dewpoint_c;
  private Double dewpoint_f;
  private Double vis_km;
  private Double vis_miles;
  private Double uv;
  private Double gust_mph;
  private Double gust_kph;

  public ExternalCurrentDTO() {

  }

  public Integer getLast_updated_epoch() {
    return last_updated_epoch;
  }

  public String getLast_updated() {
    return last_updated;
  }

  public Double getTemp_c() {
    return temp_c;
  }

  public Double getTemp_f() {
    return temp_f;
  }

  public Short getIs_day() {
    return is_day;
  }

  public ExternalConditionDTO getCondition() {
    return condition;
  }

  public Double getWind_mph() {
    return wind_mph;
  }

  public Double getWind_kph() {
    return wind_kph;
  }

  public Short getWind_degree() {
    return wind_degree;
  }

  public String getWind_dir() {
    return wind_dir;
  }

  public Double getPressure_mb() {
    return pressure_mb;
  }

  public Double getPressure_in() {
    return pressure_in;
  }

  public Double getPrecip_mm() {
    return precip_mm;
  }

  public Double getPrecip_in() {
    return precip_in;
  }

  public Short getHumidity() {
    return humidity;
  }

  public Short getCloud() {
    return cloud;
  }

  public Double getFeelslike_c() {
    return feelslike_c;
  }

  public Double getFeelslike_f() {
    return feelslike_f;
  }

  public Double getWindchill_c() {
    return windchill_c;
  }

  public Double getWindchill_f() {
    return windchill_f;
  }

  public Double getHeatindex_c() {
    return heatindex_c;
  }

  public Double getHeatindex_f() {
    return heatindex_f;
  }

  public Double getDewpoint_c() {
    return dewpoint_c;
  }

  public Double getDewpoint_f() {
    return dewpoint_f;
  }

  public Double getVis_km() {
    return vis_km;
  }

  public Double getVis_miles() {
    return vis_miles;
  }

  public Double getUv() {
    return uv;
  }

  public Double getGust_mph() {
    return gust_mph;
  }

  public Double getGust_kph() {
    return gust_kph;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExternalCurrentDTO that = (ExternalCurrentDTO) o;
    return Objects.equals(last_updated_epoch, that.last_updated_epoch) && Objects.equals(last_updated, that.last_updated) && Objects.equals(temp_c, that.temp_c) && Objects.equals(temp_f, that.temp_f) && Objects.equals(is_day, that.is_day) && Objects.equals(condition, that.condition) && Objects.equals(wind_mph, that.wind_mph) && Objects.equals(wind_kph, that.wind_kph) && Objects.equals(wind_degree, that.wind_degree) && Objects.equals(wind_dir, that.wind_dir) && Objects.equals(pressure_mb, that.pressure_mb) && Objects.equals(pressure_in, that.pressure_in) && Objects.equals(precip_mm, that.precip_mm) && Objects.equals(precip_in, that.precip_in) && Objects.equals(humidity, that.humidity) && Objects.equals(cloud, that.cloud) && Objects.equals(feelslike_c, that.feelslike_c) && Objects.equals(feelslike_f, that.feelslike_f) && Objects.equals(windchill_c, that.windchill_c) && Objects.equals(windchill_f, that.windchill_f) && Objects.equals(heatindex_c, that.heatindex_c) && Objects.equals(heatindex_f, that.heatindex_f) && Objects.equals(dewpoint_c, that.dewpoint_c) && Objects.equals(dewpoint_f, that.dewpoint_f) && Objects.equals(vis_km, that.vis_km) && Objects.equals(vis_miles, that.vis_miles) && Objects.equals(uv, that.uv) && Objects.equals(gust_mph, that.gust_mph) && Objects.equals(gust_kph, that.gust_kph);
  }

  @Override
  public int hashCode() {
    return Objects.hash(last_updated_epoch, last_updated, temp_c, temp_f, is_day, condition, wind_mph, wind_kph, wind_degree, wind_dir, pressure_mb, pressure_in, precip_mm, precip_in, humidity, cloud, feelslike_c, feelslike_f, windchill_c, windchill_f, heatindex_c, heatindex_f, dewpoint_c, dewpoint_f, vis_km, vis_miles, uv, gust_mph, gust_kph);
  }

  @Override
  public String toString() {
    return "ExternalCurrentDTO{" +
           "last_updated_epoch=" + last_updated_epoch +
           ", last_updated='" + last_updated + '\'' +
           ", temp_c=" + temp_c +
           ", temp_f=" + temp_f +
           ", is_day=" + is_day +
           ", condition=" + condition +
           ", wind_mph=" + wind_mph +
           ", wind_kph=" + wind_kph +
           ", wind_degree=" + wind_degree +
           ", wind_dir=" + wind_dir +
           ", pressure_mb=" + pressure_mb +
           ", pressure_in=" + pressure_in +
           ", precip_mm=" + precip_mm +
           ", precip_in=" + precip_in +
           ", humidity=" + humidity +
           ", cloud=" + cloud +
           ", feelslike_c=" + feelslike_c +
           ", feelslike_f=" + feelslike_f +
           ", windchill_c=" + windchill_c +
           ", windchill_f=" + windchill_f +
           ", heatindex_c=" + heatindex_c +
           ", heatindex_f=" + heatindex_f +
           ", dewpoint_c=" + dewpoint_c +
           ", dewpoint_f=" + dewpoint_f +
           ", vis_km=" + vis_km +
           ", vis_miles=" + vis_miles +
           ", uv=" + uv +
           ", gust_mph=" + gust_mph +
           ", gust_kph=" + gust_kph +
           '}';
  }
}
