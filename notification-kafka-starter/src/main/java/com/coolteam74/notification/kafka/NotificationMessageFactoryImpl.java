package com.coolteam74.notification.kafka;

import com.coolteam74.mq.notification.core.IMessageFactory;
import com.coolteam74.mq.notification.core.model.NotificationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
@ConditionalOnProperty(prefix = "mq", name = "notification", havingValue = "service")
public class NotificationMessageFactoryImpl implements IMessageFactory {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final MessageChannel channel;

    @Override
    public void sendMessage(NotificationMessage... messages) {


        Stream.of(messages).forEach(request -> {
            NotificationMessage message = null;
            try {
                NotificationMessage.NotificationMessageBuilder<?, ?> messageBuilder = NotificationMessage.builder()
                        .topic(request.getTopic());
                messageBuilder.body(objectMapper.writeValueAsString(request));
                message = messageBuilder.build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            channel.send(MessageBuilder.withPayload(message).build());
        });
    }
}
