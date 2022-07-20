package com.coolteam74.notification.kafka;

import com.coolteam74.mq.notification.core.IMessageFactory;
import com.coolteam74.mq.notification.core.model.NotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@ConditionalOnProperty(prefix = "mq", name = "notification", havingValue = "kafka")
@RequiredArgsConstructor
public class KafkaMessageFactoryImpl implements IMessageFactory {
    private final MessageChannel channel;

    @Override
    public void sendMessage(NotificationMessage... messages) {
        Arrays.stream(messages).forEach(
                pubSubInfo -> {
                    try {
                        channel.send(MessageBuilder.withPayload(pubSubInfo).build());
                        log.info("message is sent to kafka successfully");
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                }
        );
    }
}
