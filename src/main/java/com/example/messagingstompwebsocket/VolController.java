package com.example.messagingstompwebsocket;

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
            }
        }

    };
}
