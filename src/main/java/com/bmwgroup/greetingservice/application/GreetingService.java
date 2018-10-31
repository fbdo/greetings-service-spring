package com.bmwgroup.greetingservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    private TimeClient timeClient;

    private WeatherClient weatherClient;

    public GreetingService(@Autowired TimeClient timeClient, @Autowired WeatherClient weatherClient) {
        this.timeClient = timeClient;
        this.weatherClient = weatherClient;
    }

    public String greetings(Optional<String> name) {

        return appendTimeData(appendWeatherData(createBufferWithName(name))).toString();

    }

    private StringBuffer createBufferWithName(Optional<String> name) {
        StringBuffer sb = new StringBuffer("Hello");
        if (name.isPresent()) {
            sb.append(" ").append(name);
        }
        sb.append("!\n\n");
        return sb;
    }

    private StringBuffer appendTimeData(StringBuffer sb) {
        return sb.append("The time is ").append(timeClient.now());
    }

    private StringBuffer appendWeatherData(StringBuffer sb) {
        WeatherData current = weatherClient.current();
        return sb.append("The temperature is ")
                .append(current.getTemperature())
                .append(" celsius degrees\n")
                .append(current.getDescription())
                .append("\n");
    }
}
