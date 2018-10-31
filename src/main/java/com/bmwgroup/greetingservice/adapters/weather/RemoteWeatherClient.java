package com.bmwgroup.greetingservice.adapters.weather;

import com.bmwgroup.greetingservice.application.WeatherClient;
import com.bmwgroup.greetingservice.application.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteWeatherClient implements WeatherClient {

    @Value("${weatherservice.url}")
    private String url;


    @Override
    public WeatherData current() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, WeatherData.class);
    }

}
