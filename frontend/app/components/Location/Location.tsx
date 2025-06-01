import React from "react";
import { FormControl, OutlinedInput, IconButton } from "@mui/material";
import MagnifyingGlassIcon from "@mui/icons-material/Search";
import { useLocationService } from "#components/Location/locationService";

const Location: React.FC = () => {
  const { handleClick, handleInput } = useLocationService();

  const StartAdornment: React.FC = () => {
    return (
      <IconButton onClick={handleClick}>
        <MagnifyingGlassIcon />
      </IconButton>
    );
  };

  return (
    <FormControl>
      <OutlinedInput endAdornment={<StartAdornment />} onInput={handleInput} />
    </FormControl>
  );
};

export default Location;
