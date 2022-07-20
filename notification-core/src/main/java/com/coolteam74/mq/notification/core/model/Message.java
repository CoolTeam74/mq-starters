package com.coolteam74.mq.notification.core.model;

public interface Message {
    void setBody(String body);
    String getBody();
    String getId();
}
