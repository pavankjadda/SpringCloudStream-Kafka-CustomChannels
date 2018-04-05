package com.kafkastreams.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Lombok creates getter, setter, tostring and builder methods

@Getter @Setter @ToString @Builder
public class Greetings
{
    private long timestamp;
    private String message;
}
