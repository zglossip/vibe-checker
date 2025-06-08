import React, { Fragment, useMemo, useState, type ReactElement } from "react";
import {
  useDetailsDrawerService,
  type DetailsDrawerService,
} from "#vibe/components/DetailsDrawer/detailsDrawerService";
import {
  Drawer,
  Fab,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
} from "@mui/material";
import {
  DeviceThermostat,
  WbSunny,
  VerticalAlignBottom,
  Cloud,
  Water,
  WaterDrop,
  Sunny,
  AcUnit,
  Foggy,
  Thunderstorm,
} from "@mui/icons-material";
import {
  NOT_AVAILABLE,
  PRECIP_SEV_NONE,
  PRECIP_TYPE_FOG,
  PRECIP_TYPE_MIXED,
  PRECIP_TYPE_NONE,
  PRECIP_TYPE_RAIN,
  PRECIP_TYPE_SNOW,
  type Precipitation,
} from "#app-context/current-weather-context.js";

const DetailsDrawer: React.FC = () => {
  const { details }: DetailsDrawerService = useDetailsDrawerService();

  const [drawerOpen, setDrawerOpen] = useState<boolean>(false);

  const toReadable = (type: string) =>
    type
      .replace(/_/g, " ")
      .split(" ")
      .map((word) => word.charAt(0).toUpperCase() + word.slice(1).toLowerCase())
      .join(" ");

  const mutableFormatter = <T,>(
    value: T,
    formatter: (v: T) => string,
  ): string => {
    return value === NOT_AVAILABLE ? NOT_AVAILABLE : formatter(value);
  };

  const formattedTempText = useMemo<string>(
    () => mutableFormatter(details.temperature, (v) => `${v}°F`),
    [details.temperature],
  );

  const formattedPrecipitation = useMemo<string>(
    () =>
      mutableFormatter<Precipitation>(details.precipitation, (v) => {
        if (v.severity === NOT_AVAILABLE || v.type === NOT_AVAILABLE) {
          return NOT_AVAILABLE;
        }

        if (v.severity == PRECIP_SEV_NONE || v.type === PRECIP_TYPE_NONE) {
          if (v.thunder) {
            return "Dry Thunder";
          }
          return "None";
        }

        return `${toReadable(v.severity)} ${toReadable(v.type)}${v.thunder ? "/Thunder" : ""}`;
      }),
    [details.precipitation],
  );

  const formattedCloudText = useMemo<string>(
    () => mutableFormatter(details.cloud, (v) => `${v}%`),
    [details.cloud],
  );

  const formattedAirPressureText = useMemo<string>(
    () => mutableFormatter(details.airPressure, (v) => `${v} inHg`),
    [details.airPressure],
  );

  const formattedHumidity = useMemo<string>(
    () => mutableFormatter(details.humidity, (v) => `${v}%`),
    [details.humidity],
  );

  const weatherIcon = useMemo<ReactElement>(() => {
    if (details.precipitation.thunder) {
      return <Thunderstorm />;
    }

    switch (details.precipitation.type) {
      case PRECIP_TYPE_NONE:
        return <Sunny />;
      case PRECIP_TYPE_FOG:
        return <Foggy />;
      case PRECIP_TYPE_MIXED:
      case PRECIP_TYPE_SNOW:
        return <AcUnit />;
      case PRECIP_TYPE_RAIN:
        return <WaterDrop />;
      default:
        return <div></div>;
    }
  }, [details.precipitation]);

  return (
    <Fragment>
      <Fab onClick={() => setDrawerOpen(true)}>
        <WbSunny />
      </Fab>
      <Drawer
        anchor="right"
        open={drawerOpen}
        onClose={() => setDrawerOpen(false)}
      >
        <List>
          <ListItem>
            <ListItemIcon>
              <DeviceThermostat />
            </ListItemIcon>
            <ListItemText
              primary={formattedTempText}
              secondary="Current Temperature"
            />
          </ListItem>
          <ListItem>
            <ListItemIcon>{weatherIcon}</ListItemIcon>
            <ListItemText
              primary={formattedPrecipitation}
              secondary="Precipitation"
            />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <Cloud />
            </ListItemIcon>
            <ListItemText
              primary={formattedCloudText}
              secondary="Cloud Coverage"
            />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <VerticalAlignBottom />
            </ListItemIcon>
            <ListItemText
              primary={formattedAirPressureText}
              secondary="Air Pressure"
            />
          </ListItem>
          <ListItem>
            <ListItemIcon>
              <Water />
            </ListItemIcon>
            <ListItemText primary={formattedHumidity} secondary="Humidity" />
          </ListItem>
        </List>
      </Drawer>
    </Fragment>
  );
};

export default DetailsDrawer;
