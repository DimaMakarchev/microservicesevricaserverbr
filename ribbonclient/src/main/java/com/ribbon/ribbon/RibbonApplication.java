package com.ribbon.ribbon;


import com.ribbon.ribbon.model.onetoone.Addres;
import com.ribbon.ribbon.model.onetoone.Company;
import com.ribbon.ribbon.model.onetoone.Passport;
import com.ribbon.ribbon.model.onetoone.Pioples;
import com.ribbon.ribbon.repo.RepoAdress;
import com.ribbon.ribbon.repo.RepoPassport;
import com.ribbon.ribbon.repo.RepoPiople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.ribbon.ribbon")
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
public class RibbonApplication implements CommandLineRunner {

    @Autowired
    private RepoPiople repoPiople;
    @Autowired
    private RepoPassport repoPassport;
    @Autowired
    private RepoAdress repoAdress;

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Passport passport = new Passport();
        passport.setId(1);
        passport.setNamber("456 777");
//        repoPassport.save(passport);

        final Addres addresYork = new Addres();
        addresYork.setId(1);
        addresYork.setAddres("New York");

        final Addres addresMoscow = new Addres();
        addresMoscow.setId(1);
        addresMoscow.setAddres("Moscow");
//
//        Set addres = Set.of(addresMoscow, addresYork);
//        repoAdress.saveAll(addres);
        final Company company = new Company();
        company.setId(1);
        company.setCompany("Sber Bank");

        Pioples pioplesBro = new Pioples(1, "BRO", passport, addresMoscow, Collections.singletonList(company));

        passport.setPioples(pioplesBro);
//        pioplesBro.setName("BRO");
//        Pioples pioplesMa = new Pioples();
//        pioplesMa.setName("MA");
//        Pioples pioplesTi = new Pioples();
//        pioplesTi.setName("TI");
//        Set<Pioples> pioples = Set.of(pioplesBro, pioplesMa, pioplesTi);
//        repoPiople.saveAll(pioples);
        repoPiople.save(pioplesBro);

        Optional<Addres> byId = repoAdress.findById(1);
        Addres addres = byId.get();
        addres.setAddres("OK ADRESS BRO");
        addres.setId(8);

        Pioples pioplesTI = new Pioples(2, "TI", passport, addres, Collections.singletonList(company));

        repoPiople.save(pioplesTI);



    }
}
