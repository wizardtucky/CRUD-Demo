package com.example.demo.aop.delete.service;

import com.example.demo.aop.delete.annotation.MonitorPreformance;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class BussnessLogic {

    @MonitorPreformance
    public void processSmth() throws InterruptedException {
        fetchRecords();
        Thread.sleep(1500);
    }

    private List<Object> fetchRecords() {return Collections.emptyList();
    }
}
