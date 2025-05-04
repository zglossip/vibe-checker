import React from "react";
import { FormControl, OutlinedInput, IconButton } from "@mui/material";
import MagnifyingGlassIcon from "@mui/icons-material/Search";

const StartAdornment = () => {
  return (
    <IconButton>
      <MagnifyingGlassIcon />
    </IconButton>
  );
};

const Location: React.ComponentType<typeof FormControl> = () => {
  return (
    <FormControl>
      <OutlinedInput endAdornment={<StartAdornment />} />
    </FormControl>
  );
};

export default Location;
