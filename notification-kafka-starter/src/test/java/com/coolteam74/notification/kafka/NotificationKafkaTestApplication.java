package com.coolteam74.notification.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Supplier;

@SpringBootApplication
@ComponentScan("com.coolteam74.notification")
@Slf4j
public class NotificationKafkaTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationKafkaTestApplication.class, args);
    }
}
