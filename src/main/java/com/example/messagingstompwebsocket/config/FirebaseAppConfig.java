package com.example.messagingstompwebsocket.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.net.URL;

@Configuration
public class FirebaseAppConfig {

    @SneakyThrows
    public FirebaseAppConfig() {
        URL resource = getClass().getClassLoader().getResource("poc-push-441b9-firebase-adminsdk-sxx38-d799267455.json");
        FileInputStream serviceAccount =
                new FileInputStream(resource.toURI().getPath());

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

    }


}