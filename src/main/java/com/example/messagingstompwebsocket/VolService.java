package com.example.messagingstompwebsocket;

import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Getter
@Setter
public class VolService {
    private List<Vol> volList;
    private SimpMessagingTemplate simpMessagingTemplate;

    public VolService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.volList = new ArrayList<>();
        this.init();
    }

    public void init(){
        Vol vol1 = new Vol();
        vol1.setNumero("AF00001");
        vol1.setEta("08:00");
        vol1.setEtd("12:00");
        vol1.setRetardEta(0);
        vol1.setRetardEtd(0);
        vol1.setDestination("NCE");

        Vol vol2 = new Vol();
        vol2.setNumero("AF00002");
        vol2.setEta("08:30");
        vol2.setEtd("11:00");
        vol2.setRetardEta(0);
        vol2.setRetardEtd(0);
        vol2.setDestination("AMS");

        Vol vol3 = new Vol();
        vol3.setNumero("AF00003");
        vol3.setEta("9:00");
        vol3.setEtd("16:00");
        vol3.setRetardEta(0);
        vol3.setRetardEtd(0);
        vol3.setDestination("JFK");

        Vol vol4 = new Vol();
        vol4.setNumero("AF00004");
        vol4.setEta("10:00");
        vol4.setEtd("11:00");
        vol4.setRetardEta(0);
        vol4.setRetardEtd(0);
        vol4.setDestination("BDX");

        Vol vol5 = new Vol();
        vol5.setNumero("AF00005");
        vol5.setEta("10:00");
        vol5.setEtd("14:00");
        vol5.setRetardEta(0);
        vol5.setRetardEtd(0);
        vol5.setDestination("NCE");

        volList = new ArrayList<>();
        volList.add(vol1);
        volList.add(vol2);
        volList.add(vol3);
        volList.add(vol4);
        volList.add(vol5);

    }

    public void modifyVolRandom(){
        Random rand = new Random();
        Vol v = volList.get(rand.nextInt(4));
        v.setRetardEtd(v.getRetardEtd() + new Random().nextInt(61));
        v.setRetardEta(v.getRetardEta() + new Random().nextInt(21));
        System.out.println("Vol modified");
        this.simpMessagingTemplate.convertAndSend("/topic/vols", v);
    }

    public void launchTest() throws InterruptedException {
        for(int i=0; i<50; i++){
            modifyVolRandom();
            Thread.sleep(5000);
        }
    }
}
