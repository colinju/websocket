package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.model.Vol;
import com.example.messagingstompwebsocket.service.VolService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VolController {

    public VolController(VolService volService) {
        this.volService = volService;
    }

    VolService volService;

    @GetMapping("/start-thread")
    public void test(){
        new Thread(r).start();
    }

    @CrossOrigin
    @GetMapping("/vols")
    public List<Vol> getVols() {
        return volService.getVolList();
    }

    private Runnable r = new Runnable() {

        @Override
        public void run() {
            try {
                volService.launchTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FirebaseMessagingException e) {
                e.printStackTrace();
            }
        }

    };


}
