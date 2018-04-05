package com.kafkastreams.stream;


import com.kafkastreams.events.GreetingsEvent;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingsStreams
{
    String INPUT = "greetings-in";
    String OUTPUT = "greetings-out";

    @Input(INPUT)
    KStream<String,GreetingsEvent> incomingGreetings();

    @Output(OUTPUT)
    MessageChannel outgoingGreetings();

}
