package com.bmwgroup.greetingservice.ports.restapi;

import com.bmwgroup.greetingservice.application.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GreetingController {

    private GreetingService greetingService;

    public GreetingController(@Autowired GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping("/greetings")
    public String greetings(@RequestParam(value = "name", required = false) Optional<String> name) {
        return greetingService.greetings(name);
    }
}
