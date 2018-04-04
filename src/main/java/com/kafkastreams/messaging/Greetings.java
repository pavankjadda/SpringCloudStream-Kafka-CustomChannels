package com.kafkastreams.messaging;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Greetings
{
    private long timestamp;
    private String message;
	
    public Greetings(long timestamp, String message)
	{
		this.timestamp=timestamp;
		this.message=message;
	}
	public long getTimestamp()
	{
		return timestamp;
	}
	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	@Override
	public String toString()
	{
		return "Greetings [timestamp=" + timestamp + ", message=" + message + "]";
	}

	public Greetings build() 
	{
			return new Greetings(timestamp, message);
	}
}
