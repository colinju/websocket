package com.example.messagingstompwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

@SpringBootApplication
public class MessagingStompWebsocketApplication {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(MessagingStompWebsocketApplication.class, args);

	}

}
