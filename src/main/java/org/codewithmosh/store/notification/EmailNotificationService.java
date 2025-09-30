package org.codewithmosh.store.notification;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email Notification Service: " + message);
    }
}
