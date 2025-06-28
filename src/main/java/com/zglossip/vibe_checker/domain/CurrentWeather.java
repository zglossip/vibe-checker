package com.zglossip.vibe_checker.domain;

import java.util.Objects;

public class CurrentWeather {

    private final Details details;
    private final Vibe vibe;

    public CurrentWeather(Details details) {
        this.details = details;
        this.vibe = new Vibe(details);
    }

    public Details getDetails() {
        return details;
    }

    public Vibe getVibe() {
        return vibe;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CurrentWeather that = (CurrentWeather) o;
        return Objects.equals(details, that.details) && Objects.equals(vibe, that.vibe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details, vibe);
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "details=" + details +
                ", vibe=" + vibe +
                '}';
    }
}
