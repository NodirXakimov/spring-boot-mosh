package org.codewithmosh.store;

import org.codewithmosh.store.notification.NotificationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

        var notificationService = context.getBean(NotificationManager.class);
        notificationService.sendNotification();
    }

}
