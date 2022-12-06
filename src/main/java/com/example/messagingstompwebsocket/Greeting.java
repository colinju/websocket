package com.example.messagingstompwebsocket;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.Map;

public class Greeting implements Message<Object> {

	private String content;
	private MessageHeaders headers;

	public Greeting() {
	}

	public Greeting(String content) {
		this.content = content;
		Map<String, Object> headers = new HashMap<>();
		headers.put("simpDestination","/topic/greetings");
		this.headers = new MessageHeaders(headers);
	}

	public String getContent() {
		return content;
	}

	@Override
	public Object getPayload() {
		return content;
	}

	@Override
	public MessageHeaders getHeaders() {

		return headers;

	}
}
