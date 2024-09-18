package com.school.Redis.Scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
//@EnableScheduling
public class Test {

    static private int count = 0;

    @Scheduled(fixedRate = 5000)
    public void testing(){
        log.info("calling time "+ LocalDateTime.now());
    }
}
