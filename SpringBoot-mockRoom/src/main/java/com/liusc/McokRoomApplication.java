package com.liusc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tio.websocket.starter.EnableTioWebSocketServer;

@SpringBootApplication
@EnableTioWebSocketServer
public class McokRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(McokRoomApplication.class,args);
    }
}
