package com.coolteam74.notification.kafka;

import com.coolteam74.mq.notification.core.IMessageFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(properties = {"mq.notification=kafka"})
class KafkaMessageFactoryImplTest {

    @Autowired
    IMessageFactory messageFactory;

    @Test
    public void whenExistsTopicProperty() {
        messageFactory.sendMessage();
    }

}
