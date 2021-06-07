package com.galleryservice.galleryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableConfigClient
public class GalleryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalleryserviceApplication.class, args);
    }

}
