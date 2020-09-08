package com.ag04smarts.sha.ScheduledTasks;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log =
            LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Time is {}", date.format(new Date()));
    }
}
