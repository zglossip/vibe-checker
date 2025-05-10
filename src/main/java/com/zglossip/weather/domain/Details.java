package com.zglossip.weather.domain;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
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

  public String getColor() {
    return "#" + Integer.toHexString(Color.HSBtoRGB(getHue(), getSaturation(), getBrightness())).substring(2);
  }

  private float getHue() {
    BigDecimal COLD = new BigDecimal("32");
    BigDecimal HOT = new BigDecimal("100.0");
    BigDecimal BLUE = new BigDecimal("-0.5");
    BigDecimal RED = new BigDecimal("-1");

    return convertScale(temperature, COLD, HOT, BLUE, RED).floatValue();
  }

  private float getSaturation(){
    return (float) (100 - cloud) /100;
  }

  private float getBrightness() {
    BigDecimal MORNING = new BigDecimal("6");
    BigDecimal EVENING = new BigDecimal("21");
    return convertScale(BigDecimal.valueOf(LocalDateTime.now().getHour()), MORNING, EVENING, BigDecimal.ZERO, BigDecimal.ONE).floatValue();
  }

  private static BigDecimal convertScale(BigDecimal value,
                                         BigDecimal scaleFromMin, BigDecimal scaleFromMax,
                                         BigDecimal scaleToMin, BigDecimal scaleToMax) {
    BigDecimal fromRange = scaleFromMax.subtract(scaleFromMin);
    BigDecimal toRange = scaleToMax.subtract(scaleToMin);
    BigDecimal normalized = value.subtract(scaleFromMin).divide(fromRange, 20, RoundingMode.HALF_UP);
    return normalized.multiply(toRange).add(scaleToMin);
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
