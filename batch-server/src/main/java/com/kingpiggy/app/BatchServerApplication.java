package com.kingpiggy.app;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@EnableBatchProcessing
@SpringBootApplication
public class BatchServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchServerApplication.class, args);
    }
}
