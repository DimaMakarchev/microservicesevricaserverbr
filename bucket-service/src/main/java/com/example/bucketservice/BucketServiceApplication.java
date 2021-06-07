package com.example.bucketservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class BucketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BucketServiceApplication.class, args);
	}

}
