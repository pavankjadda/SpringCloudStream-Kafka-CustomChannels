package com.kafkastreams.service;

import com.kafkastreams.events.GreetingsEvent;
import com.kafkastreams.model.Greetings;
import com.kafkastreams.stream.GreetingsStreams;

import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.apache.kafka.common.serialization.Serdes;


@Service
@Slf4j
@EnableAutoConfiguration
public class GreetingsSender
{
    @Autowired
	private  GreetingsStreams  greetingsStreams;

    public void send(Greetings greetings)
    {
        MessageChannel messageChannel = greetingsStreams.outgoingGreetings();
        GreetingsEvent  greetingsEvent=new GreetingsEvent(greetings,greetings.getMessage());
        messageChannel.send(MessageBuilder
                .withPayload(greetingsEvent)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }

}
