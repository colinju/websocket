package com.example.messagingstompwebsocket;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GreetingService {

    private SimpMessagingTemplate simpMessagingTemplate;

    // Simple insert in web socket
    public void test(int i){
        this.simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting(i+" : Hello !"));
        System.out.println(i);

    }

    public void launchTest() throws InterruptedException {
        for(int i=0; i<50; i++){
            test(i);
            Thread.sleep(2500);
        }
    }
}
