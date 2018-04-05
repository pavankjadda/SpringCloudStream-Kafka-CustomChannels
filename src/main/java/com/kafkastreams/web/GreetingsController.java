package com.kafkastreams.web;

import com.kafkastreams.model.Greetings;
import com.kafkastreams.service.GreetingsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController
{
    @Autowired
    private GreetingsSender greetingsSender;

    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send()
    {
        String message = "Hello, Welcome to Spring Stream ";
        Greetings greetings = Greetings.builder().message(message).timestamp(System.currentTimeMillis()).build();
        greetingsSender.send(greetings);
    }
}
