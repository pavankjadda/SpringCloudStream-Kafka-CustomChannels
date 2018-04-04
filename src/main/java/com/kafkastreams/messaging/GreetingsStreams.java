package com.kafkastreams.messaging;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingsStreams
{
    public String INPUT = "greetings_input";
    public String OUTPUT = "greetings_output";

    @Input(INPUT)
    SubscribableChannel incomingGreetings();

    @Output(OUTPUT)
    MessageChannel outgoingGreetings();
}
