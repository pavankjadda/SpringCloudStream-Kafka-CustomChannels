package com.kafkastreams.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class GreetingsSender
{
    @Autowired
    private GreetingsStreams greetingsStreams;

    public void send(Greetings greetings)
    {
        greetingsStreams.outgoingGreetings().send(MessageBuilder.withPayload(greetings).build());

    }

}
