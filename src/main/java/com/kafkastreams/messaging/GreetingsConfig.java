package com.kafkastreams.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public interface GreetingsConfig
{

}
