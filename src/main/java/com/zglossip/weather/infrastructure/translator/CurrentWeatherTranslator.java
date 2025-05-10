package com.zglossip.weather.infrastructure.translator;

import com.zglossip.weather.domain.Details;
import com.zglossip.weather.domain.Precipitation;
import com.zglossip.weather.domain.enums.PrecipitationType;
import com.zglossip.weather.domain.enums.Severity;
import com.zglossip.weather.infrastructure.dto.ExternalCurrentResponseDTO;

import java.math.BigDecimal;

public class CurrentWeatherTranslator {

  public static Details translate(final ExternalCurrentResponseDTO response) {
    Details currentWeather = new Details();
    currentWeather.setTemperature(BigDecimal.valueOf(response.getCurrent().getTemp_f()));
    currentWeather.setHumidity(response.getCurrent().getHumidity());
    currentWeather.setWind(BigDecimal.valueOf(response.getCurrent().getGust_mph()));
    currentWeather.setAirPressure(BigDecimal.valueOf(response.getCurrent().getPressure_in()));
    currentWeather.setCloud(response.getCurrent().getCloud());

    Precipitation precipitation = new Precipitation();
    precipitation.setType(getType(response.getCurrent().getCondition().getCode()));
    precipitation.setThunder(hasThunder(response.getCurrent().getCondition().getCode()));
    precipitation.setSeverity(getSeverity(response.getCurrent().getCondition().getCode()));

    currentWeather.setPrecipitation(precipitation);

    return currentWeather;
  }

  private static PrecipitationType getType(Short code) {
    switch (code) {
      case 1066:
      case 1114:
      case 1117:
      case 1210:
      case 1213:
      case 1216:
      case 1219:
      case 1222:
      case 1225:
      case 1255:
      case 1258:
      case 1279:
      case 1282:
        return PrecipitationType.SNOW;
      case 1069:
      case 1072:
      case 1168:
      case 1171:
      case 1198:
      case 1201:
      case 1204:
      case 1207:
      case 1249:
      case 1252:
        return PrecipitationType.MIXED;
      case 1063:
      case 1150:
      case 1153:
      case 1180:
      case 1183:
      case 1186:
      case 1189:
      case 1192:
      case 1195:
      case 1240:
      case 1243:
      case 1246:
      case 1273:
      case 1276:
        return PrecipitationType.RAIN;
      case 1030:
      case 1135:
      case 1147:
        return PrecipitationType.FOG;
      default:
        return PrecipitationType.NONE;
    }
  }

  private static boolean hasThunder(Short code) {
    switch(code) {
      case 1087:
      case 1273:
      case 1276:
      case 1279:
      case 1282:
        return true;
      default:
        return false;
    }
  }

  private static Severity getSeverity(Short code) {
    switch (code) {
      case 1117:
      case 1237:
      case 1246:
      case 1264:
        return Severity.EXTRA_HIGH;
      case 1114:
      case 1192:
      case 1195:
      case 1201:
      case 1207:
      case 1222:
      case 1225:
      case 1243:
      case 1252:
      case 1258:
      case 1261:
      case 1276:
      case 1282:
        return Severity.HIGH;
      case 1030:
      case 1171:
      case 1186:
      case 1189:
      case 1216:
      case 1219:
        return Severity.MEDIUM;
      case 1063:
      case 1066:
      case 1069:
      case 1072:
      case 1135:
      case 1147:
      case 1150:
      case 1153:
      case 1168:
      case 1180:
      case 1183:
      case 1198:
      case 1204:
      case 1210:
      case 1213:
      case 1240:
      case 1249:
      case 1255:
      case 1273:
      case 1279:
        return Severity.LOW;
      default:
        return Severity.NONE;
    }
  }

}
