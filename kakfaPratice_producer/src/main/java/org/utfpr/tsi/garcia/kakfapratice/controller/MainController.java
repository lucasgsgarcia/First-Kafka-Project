package org.utfpr.tsi.garcia.kakfapratice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class MainController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public ResponseEntity<?> send(){
        kafkaTemplate.send("topic-1", "Data e hora atual: " +  new Date().getSeconds());
        return ResponseEntity.ok().build();
    }
}
