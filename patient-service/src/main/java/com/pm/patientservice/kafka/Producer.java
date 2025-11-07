package com.pm.patientservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;

public class Producer {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;


    public Producer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

     
}
