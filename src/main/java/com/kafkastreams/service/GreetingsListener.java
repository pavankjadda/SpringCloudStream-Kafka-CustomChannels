package com.kafkastreams.service;
import com.kafkastreams.stream.GreetingsStreams;
import com.kafkastreams.model.Greetings;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsListener
{
    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(String  greetings)
    {
        log.info("Received greetings: {}", greetings);
    }
}

