package com.kafkastreams.service;

import com.kafkastreams.model.Greetings;
import com.kafkastreams.stream.GreetingsStreams;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
@EnableAutoConfiguration
public class GreetingsSender
{
    //@Autowired
	//private  GreetingsStreams  greetingsStreams;

    private final GreetingsStreams greetingsStreams;

    public GreetingsSender(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }
    public void send(Greetings greetings)
    {
        MessageChannel messageChannel = greetingsStreams.outgoingGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    }

}
