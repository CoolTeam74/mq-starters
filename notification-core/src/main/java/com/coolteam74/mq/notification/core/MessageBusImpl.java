package com.coolteam74.mq.notification.core;

import com.coolteam74.mq.notification.core.model.NotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class MessageBusImpl implements IMessageBus {
    private final List<IMessageFactory> messageFactories;

    @Override
    public void publishMessage(NotificationMessage... messages) {
        messageFactories.forEach(iMessageFactory -> {
            iMessageFactory.sendMessage( messages );
        });
    }
}
