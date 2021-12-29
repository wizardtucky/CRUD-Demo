package com.example.demo.aop.delete;

import com.example.demo.aop.delete.service.BussnessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    @Autowired
    private BussnessLogic bussinesLogicService;

    public static void main(String[] args){
        SpringApplication.run(AopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bussinesLogicService.processSmth();
    }

}
