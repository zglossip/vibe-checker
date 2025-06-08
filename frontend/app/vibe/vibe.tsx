import React from "react";
import Location from './components/Location/Location'
import VibeContainer from "./components/VibeContainer/VibeContainer";
import DetailsDrawer from "./components/DetailsDrawer/DetailsDrawer";

export function Vibe() {
    return (
        <main className="px-5 flex items-right">
            <Location />
            <VibeContainer />
            <DetailsDrawer />
        </main>
    )
}