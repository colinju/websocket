package com.example.messagingstompwebsocket;

import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Greeting implements Message<Object>, Serializable {

    private final String content;
    private final MessageHeaders headers;

    public Greeting(String content) {
        this.content = content;
        Map<String, Object> headers = new HashMap<>();
        headers.put("simpDestination", "/topic/greetings");
        this.headers = new MessageHeaders(headers);
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
