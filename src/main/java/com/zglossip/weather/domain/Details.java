package com.zglossip.weather.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Details {

  private BigDecimal temperature;
  private Precipitation precipitation;
  private Short humidity;
  private BigDecimal wind;
  private BigDecimal airPressure;
  private Short cloud;

  public Details() {

  }

  public BigDecimal getTemperature() {
    return temperature;
  }

  public void setTemperature(BigDecimal temperature) {
    this.temperature = temperature;
  }

  public Precipitation getPrecipitation() {
    return precipitation;
  }

  public void setPrecipitation(Precipitation precipitation) {
    this.precipitation = precipitation;
  }

  public Short getHumidity() {
    return humidity;
  }

  public void setHumidity(Short humidity) {
    this.humidity = humidity;
  }

  public BigDecimal getWind() {
    return wind;
  }

  public void setWind(BigDecimal wind) {
    this.wind = wind;
  }

  public BigDecimal getAirPressure() {
    return airPressure;
  }

  public void setAirPressure(BigDecimal airPressure) {
    this.airPressure = airPressure;
  }

  public Short getCloud() {
    return cloud;
  }

  public void setCloud(Short cloud) {
    this.cloud = cloud;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Details that = (Details) o;
    return Objects.equals(temperature, that.temperature) && Objects.equals(precipitation, that.precipitation) && Objects.equals(humidity, that.humidity) && Objects.equals(wind, that.wind) && Objects.equals(airPressure, that.airPressure) && Objects.equals(cloud, that.cloud);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, precipitation, humidity, wind, airPressure, cloud);
  }

  @Override
  public String toString() {
    return "CurrentWeatherDTO{" +
           "temperature=" + temperature +
           ", precipitation=" + precipitation +
           ", humidity=" + humidity +
           ", wind=" + wind +
           ", airPressure=" + airPressure +
           ", cloud=" + cloud +
           '}';
  }
}
