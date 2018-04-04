package com.kafkastreams.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class GreetingsSender
{
    @Autowired
	private MessageChannel output; 

    public void send(Greetings greetings)
    {
        output.send(MessageBuilder.withPayload(greetings).build());

    }

}
