package com.zglossip.weather.domain;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Vibe {
    private final String color;

    public Vibe(Details details) {
        this.color = generateColor(details.getTemperature(), details.getCloud());
    }

    public String getColor() {
        return this.color;
    }

    private String generateColor(BigDecimal temperature, Short cloud) {
        return "#" + Integer.toHexString(Color.HSBtoRGB(getHue(temperature), getSaturation(cloud), getBrightness())).substring(2);
    }

    private float getHue(BigDecimal temperature) {
        BigDecimal COLD = new BigDecimal("32");
        BigDecimal HOT = new BigDecimal("100.0");
        BigDecimal BLUE = new BigDecimal("-0.5");
        BigDecimal RED = new BigDecimal("-1");

        return convertScale(temperature, COLD, HOT, BLUE, RED).floatValue();
    }

    private float getSaturation(Short cloud){
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
}
