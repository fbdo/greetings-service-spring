package com.bmwgroup.greetingservice.adapters.time;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeResource {
    private int seconds;
    private int minutes;
    private int hours;
    private int day;
    private int month;
    private int year;

    @JsonCreator
    public TimeResource(
            @JsonProperty("seconds") int seconds,
            @JsonProperty("minutes") int minutes,
            @JsonProperty("hours") int hours,
            @JsonProperty("day") int day,
            @JsonProperty("month") int month,
            @JsonProperty("year") int year) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
