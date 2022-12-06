package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    GreetingService service;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @GetMapping("/test")
    public void test() throws Exception {
        new Thread(r).start();
    }

    private Runnable r = new Runnable() {

        @Override
        public void run() {
            try {
                service.launchTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };
}
