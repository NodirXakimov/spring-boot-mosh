package org.codewithmosh.store;

import org.codewithmosh.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

//        var orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();
//
//        var notificationService = context.getBean(NotificationManager.class);
//        notificationService.sendNotification();
//
//
//        var userService = context.getBean(UserService.class);
//        userService.registerUser(new User(1L, "Nodir", "password", "nodir@gmail.com"));
//        var user = User.builder()
//                .name("John")
//                .password("123")
//                .email("email@gmail.com")
//                .build();

//        var address = Address.builder()
//                .street("123 Main St")
//                .city("Main St")
//                .zip("123 Main St")
//                .build();
//
//        user.addAddress(address);

//        user.addTag("tag1");

//        var profile = Profile.builder()
//                .bio("User bio")
//                .build();
//        user.setProfile(profile);
//        profile.setUser(user);
//
//        System.out.println(user);


//        var user = User.builder()
//                .name("admin")
//                .email("admin@gmail.com")
//                .password("admin")
//                .build();
//        repository.save(user);

//        var repository = context.getBean(UserRepository.class);
//        var retrievedUser = repository.findById(1L).orElseThrow();
//        System.out.println(retrievedUser.getEmail());

        var service = context.getBean(UserService.class);
//        service.showEntityStates();
//        service.showRelatedEntities();
//        service.fetchAddresses();
//        service.persistRelated();
        service.deleteRelated();
    }
}
