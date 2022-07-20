package com.coolteam74.mq.notification.core;

import com.coolteam74.mq.notification.core.model.MessageImpl;
import com.coolteam74.mq.notification.core.model.NotificationMessage;

public interface IMessageBus {
    void publishMessage(NotificationMessage... messages);
}
