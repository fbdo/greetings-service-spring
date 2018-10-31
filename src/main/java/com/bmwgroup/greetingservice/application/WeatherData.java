package com.bmwgroup.greetingservice.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    private double temperature;
    private String description;

    @JsonCreator
    public WeatherData(@JsonProperty("temperature") double temperature, @JsonProperty("description") String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}
