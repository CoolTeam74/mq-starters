package com.coolteam74.notification.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.coolteam74.notification")
public class NotificationKafkaTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationKafkaTestApplication.class, args);
    }
}
