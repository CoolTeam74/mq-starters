package com.coolteam74.mq.notification.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationMessage implements Message {
    private String topic;
    protected String id;
    protected String body;
}
