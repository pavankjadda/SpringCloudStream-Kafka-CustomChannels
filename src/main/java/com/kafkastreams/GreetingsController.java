package com.kafkastreams;

import com.kafkastreams.messaging.Greetings;
import com.kafkastreams.messaging.GreetingsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController
{
    @Autowired
    private GreetingsSender greetingsSender;

    @GetMapping("/greetings")
    public void send()
    {
        String message = "Hello, Welcome to Spring Stream ";
        //Greetings greetings = Greetings.builder().message(message).timestamp(System.currentTimeMillis()).build();
        Greetings greetings=new Greetings(System.currentTimeMillis(), message);
        greetingsSender.send(greetings);
    }
}
