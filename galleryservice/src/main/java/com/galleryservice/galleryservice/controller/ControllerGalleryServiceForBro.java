package com.galleryservice.galleryservice.controller;

import com.galleryservice.galleryservice.model.Bucket;
import com.galleryservice.galleryservice.repo.RepoBucketForBro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
@EnableTransactionManagement
public class ControllerGalleryServiceForBro {
    private Logger logger = Logger.getLogger(ControllerGalleryServiceForBro.class.getName());
    @Autowired
    private Environment env;

    @Autowired
    private RepoBucketForBro repoBucketForBro;

    @RequestMapping("/get")
    public Object get() {

//        List<Bucket> all = repoBucketForBro.findAll();
//        Bucket bucket = all.get(0);
//        @NotBlank @Size(max = 10) String title = bucket.getTitle();
        return repoBucketForBro.findById(1);

    }
    @RequestMapping("/")
    public Object getIp() {

        String home = "Gallery-Service running at port: " + env.getProperty("local.server.port");
        return home;

    }

    @GetMapping(value = "/stream")
    public Optional<Bucket> streamAllBucketsDelay() {
        logger.info("Get data from database (WebClient on User-Service side)");
        return repoBucketForBro.findById(1);
//        return bucketRepository.findAll().delayElements(Duration.ofSeconds(2));
    }

}
