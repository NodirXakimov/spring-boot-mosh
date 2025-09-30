package org.codewithmosh.store.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
@Primary
public class SMSNotificationService implements NotificationService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS Notification Service: " + message);
    }
}
