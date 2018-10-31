package com.bmwgroup.greetingservice.adapters.time;

import com.bmwgroup.greetingservice.application.TimeClient;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RemoteTimeClient implements TimeClient  {

    @Value("${timeservice.url}")
    private String url;

    @Override
    public DateTime now() {

        RestTemplate restTemplate = new RestTemplate();

        TimeResource time = restTemplate.getForObject(url, TimeResource.class);

        return new DateTime(time.getYear(), time.getMonth(), time.getDay(), time.getHours(), time.getMinutes(), time.getSeconds());
    }
}
