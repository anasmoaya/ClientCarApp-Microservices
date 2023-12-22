package com.control.client;

import com.control.client.controller.ClientController;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);




    }

}
