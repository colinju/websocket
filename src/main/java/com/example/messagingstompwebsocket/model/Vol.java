package com.example.messagingstompwebsocket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vol {
    private String numero;
    private String eta;
    private String etd;
    private String depart;
    private String destination;
    private Integer retardEta;
    private Integer retardEtd;
    private String compagnie;
    private String avion;
}
