package com.coolteam74.notification.kafka;

import com.coolteam74.mq.notification.core.IMessageFactory;
import com.coolteam74.mq.notification.core.model.NotificationMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(properties = {"mq.notification=kafka"})
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class KafkaMessageFactoryImplTest {

    @Autowired
    IMessageFactory messageFactory;

    @Test
    public void whenExistsTopicProperty() {
        NotificationMessage message = NotificationMessage.builder()
                .topic("test")
                .body("Hello World!")
                .build();
        messageFactory.sendMessage(message);
    }

}
