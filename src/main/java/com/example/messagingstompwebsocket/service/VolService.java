package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.model.Vol;
import com.google.firebase.messaging.FirebaseMessagingException;
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
    private PushNotifService pushNotifService;

    public VolService(SimpMessagingTemplate simpMessagingTemplate, PushNotifService pushNotifService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.pushNotifService = pushNotifService;
        this.volList = new ArrayList<>();
        this.init();
    }

    public void init(){

        for (int i = 0; i < 500; i++) {
            Vol vol = new Vol();
            vol.setNumero("AF0000" + i);
            vol.setEta("10:00");
            vol.setEtd("14:00");
            vol.setRetardEta(0);
            vol.setRetardEtd(0);
            vol.setDestination(getRandomDestination());
            vol.setDepart(getRandomDestination());
            vol.setCompagnie(getRandomCompanie());
            vol.setAvion(getRandomAvion());
            volList.add(vol);
        }

    }


    ArrayList<String> companies = new ArrayList<>();
    {
        companies.add("Air France");
        companies.add("Ryanair");
        companies.add("Easyjet");
        companies.add("British Airways");
        companies.add("Lufthansa");
        companies.add("KLM");
        companies.add("Air Canada");
        companies.add("Air China");
        companies.add("Air India");
        companies.add("Alitalia");
        companies.add("American Airlines");
        companies.add("Asiana Airlines");
        companies.add("Austrian Airlines");
        companies.add("Avianca");
        companies.add("Cathay Pacific");
        companies.add("China Eastern Airlines");
        companies.add("China Southern Airlines");
        companies.add("Delta Air Lines");
    }

    String getRandomCompanie() {
        Random rand = new Random();
        return companies.get(rand.nextInt(companies.size()));
    }

    ArrayList<String> destinations = new ArrayList<>();
    {
        destinations.add("NCE");
        destinations.add("CDG");
        destinations.add("ORY");
        destinations.add("LHR");
        destinations.add("FRA");
        destinations.add("AMS");
        destinations.add("YYZ");
        destinations.add("PEK");
        destinations.add("DEL");
        destinations.add("FCO");
        destinations.add("DFW");
        destinations.add("ICN");
        destinations.add("VIE");
        destinations.add("BOG");
        destinations.add("HKG");
        destinations.add("PVG");
        destinations.add("CAN");
        destinations.add("ATL");
    }

    String getRandomDestination() {
        Random rand = new Random();
        return destinations.get(rand.nextInt(destinations.size()));
    }

    ArrayList<String> avions = new ArrayList<>();
    {
        avions.add("Airbus 333");
        avions.add("Airbus 320");
        avions.add("Airbus 321");
        avions.add("Airbus 319");
        avions.add("Airbus 318");
        avions.add("Airbus 319");
        avions.add("Boeing 737");
        avions.add("Boeing 747");
        avions.add("Boeing 757");
        avions.add("Boeing 767");
        avions.add("Boeing 777");
        avions.add("Boeing 787");
    }

    String getRandomAvion() {
        Random rand = new Random();
        return avions.get(rand.nextInt(avions.size()));
    }


    public void modifyVolRandom() throws FirebaseMessagingException {
        Random rand = new Random();
        Vol v = volList.get(rand.nextInt(volList.size()));
        v.setRetardEtd(v.getRetardEtd() + new Random().nextInt(61));
        v.setRetardEta(v.getRetardEta() + new Random().nextInt(21));
        pushNotifService.sendNotif(v);
        System.out.println("Vol modified");
        this.simpMessagingTemplate.convertAndSend("/topic/vols", v);
    }

    public void launchTest() throws InterruptedException, FirebaseMessagingException {
        for(int i=0; i<500; i++){
            modifyVolRandom();
            Thread.sleep(1000);
        }
    }
}
