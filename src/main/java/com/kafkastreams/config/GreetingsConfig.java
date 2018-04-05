package com.kafkastreams.config;

import com.kafkastreams.stream.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public interface GreetingsConfig
{

}
