package com.zglossip.weather.domain;

import com.zglossip.weather.domain.enums.PrecipitationType;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.zglossip.weather.domain.enums.PrecipitationType.*;
import static com.zglossip.weather.domain.enums.Severity.EXTRA_HIGH;
import static com.zglossip.weather.domain.enums.Severity.HIGH;

public class Vibe {
    private final String color;
    private final String color2;
    private final String text;

    private static final BigDecimal COLD = new BigDecimal("32");
    private static final BigDecimal HOT = new BigDecimal("100.0");
    private static final BigDecimal BLUE = new BigDecimal("-0.5");
    private static final BigDecimal RED = new BigDecimal("-1");

    private static final BigDecimal MORNING = new BigDecimal("6");
    private static final BigDecimal EVENING = new BigDecimal("21");

    private static final String RAIN_HEX = "#237fe8";
    private static final String SNOW_HEX = "#ebf3fc";
    private static final String FOG_MIXED_HEX = "#92ebfc";

    private static final String MUGGY = "Muggy";

    private static final String EERIE = "Eerie";
    private static final String LAID_BACK = "Laid back";
    private static final String ROUGH = "Rough";
    private static final String WILD = "Wild";

    private static final String OMINOUS = "Ominous";
    private static final String TREACHEROUS = "Treacherous";
    private static final String SCARY = "Scary";
    private static final String CHILL = "Chill";
    private static final String RELAXED = "Relaxed";
    private static final String DANGEROUS = "Dangerous";
    private static final String DREARY = "Dreary";
    private static final String CREEPY = "Creepy";

    private static final String PAINFUL = "Painful";
    private static final String UNCOMFORTABLE = "Uncomfortable";
    private static final String COMFORTABLE = "Comfortable";

    public Vibe(Details details) {
        this.color = generateColor(details.getTemperature(), details.getCloud());
        this.color2 = generateColor2(details.getPrecipitation().getType());
        this.text = generateText(details.getHumidity(), details.getWind(), details.getPrecipitation(), details.getAirPressure());
    }

    public String getColor() {
        return this.color;
    }

    public String getColor2() {
        return color2;
    }

    public String getText() {
        return text;
    }

    private String generateColor(BigDecimal temperature, Short cloud) {
        return "#" + Integer.toHexString(Color.HSBtoRGB(getHue(temperature), getSaturation(cloud), getBrightness())).substring(2);
    }

    private String generateColor2(PrecipitationType precipitationType) {
        switch (precipitationType) {
            case RAIN:
                return RAIN_HEX;
            case SNOW:
                return SNOW_HEX;
            case MIXED:
            case FOG:
                return FOG_MIXED_HEX;
            default:
                return this.color;
        }
    }

    private String generateText(Short humidity, BigDecimal wind, Precipitation precipitation, BigDecimal pressure) {
        return Stream.of(generateHumidityAdj(humidity), generateWindAdj(wind), generatePrecAdj(precipitation), getPressureAdj(pressure))
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }

    private String generateHumidityAdj(Short humidity) {
        if(humidity > 50) {
            return MUGGY;
        }

        return null;
    }

    private String generateWindAdj(BigDecimal wind) {
        if(wind.equals(BigDecimal.ZERO)) {
            return EERIE;
        } else if (wind.compareTo(new BigDecimal("25")) < 0){
            return LAID_BACK;
        } else if (wind.compareTo(new BigDecimal("39")) < 0) {
            return ROUGH;
        } else {
            return WILD;
        }
    }

    private String generatePrecAdj(Precipitation precipitation) {
        if(precipitation.isThunder()) {
            if(NONE.equals(precipitation.getType()) || FOG.equals(precipitation.getType())) {
                return OMINOUS;
            } else if(SNOW.equals(precipitation.getType()) || RAIN.equals(precipitation.getType())) {
                return TREACHEROUS;
            } else if(MIXED.equals(precipitation.getType())) {
                return SCARY;
            }
        } else {
            if(EXTRA_HIGH.equals(precipitation.getSeverity()) || HIGH.equals(precipitation.getSeverity())) {
                if(SNOW.equals(precipitation.getType()) || RAIN.equals(precipitation.getType())) {
                    return DANGEROUS;
                }
            } else {
                if(SNOW.equals(precipitation.getType())) {
                    return CHILL;
                } else if (RAIN.equals(precipitation.getType())) {
                    return RELAXED;
                } else if (FOG.equals(precipitation.getType())) {
                    return DREARY;
                } else if (MIXED.equals(precipitation.getType())) {
                    return CREEPY;
                }
            }
        }

        return null;
    }

    private String getPressureAdj(BigDecimal pressure) {
        if(new BigDecimal("29.20").compareTo(pressure) > 0 || new BigDecimal("30.40").compareTo(pressure) < 0) {
            return PAINFUL;
        } else if(new BigDecimal("29.40").compareTo(pressure) > 0 || new BigDecimal("30.20").compareTo(pressure) < 0) {
            return UNCOMFORTABLE;
        }

        return COMFORTABLE;
    }

    private float getHue(BigDecimal temperature) {
        return convertScale(temperature, COLD, HOT, BLUE, RED).floatValue();
    }

    private float getSaturation(Short cloud){
        return (float) (100 - cloud) /100;
    }

    private float getBrightness() {
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
