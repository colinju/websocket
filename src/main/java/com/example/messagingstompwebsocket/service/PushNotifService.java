package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.model.Vol;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class PushNotifService {

    public void sendNotif(Vol dataMessage) throws FirebaseMessagingException {

        Notification.Builder builder = Notification.builder();
        Message message = Message.builder()
                .setNotification(builder.build())
                .putData("title", dataMessage.getNumero())
                .putData("body", dataMessage.toString())
                .setTopic("554691658309")
                .build();
        String notif = FirebaseMessaging.getInstance().send(message);
        System.out.println("notification sent: "+ notif);
    }
}
