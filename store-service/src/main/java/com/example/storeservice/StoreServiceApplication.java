package com.example.storeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableKafka

public class StoreServiceApplication {

	@KafkaListener(topics="msg")
	public void msgListener(int msg){
		System.out.println(msg);
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceApplication.class, args);
	}


}
