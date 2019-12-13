package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author hezhensheng
 * @version 1.0
 * @description ScheduledServices
 * @date 2019/12/7 21:31
 */

@Slf4j
@Component
public class ScheduledServices {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() {
        System.out.println("execute = " + sdf.format(new Date()));
    }

}
