package com.example.messagingstompwebsocket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vol {
    private String numero;
    private String eta;
    private String etd;
    private String destination;
    private Integer retardEta;
    private Integer retardEtd;
}
