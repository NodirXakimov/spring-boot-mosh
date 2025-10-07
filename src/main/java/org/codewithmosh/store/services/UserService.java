package org.codewithmosh.store.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.codewithmosh.store.entities.Address;
import org.codewithmosh.store.entities.Category;
import org.codewithmosh.store.entities.Product;
import org.codewithmosh.store.entities.User;
import org.codewithmosh.store.repositories.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("Daniel")
                .email("daniel@gmail.com")
                .password("password")
                .build();
        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getPassword());
    }

    public void fetchAddresses() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Daniel")
                .email("daniel@mail.com")
                .password("password")
                .build();
        var address = Address.builder()
                .street("123 Main St")
                .city("Main St")
                .zip("12345")
                .state("Main State")
                .build();
        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(2L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts(){
//        var category =  Category.builder()
//                .name("Mobile phone")
//                .build();
//        var category = categoryRepository.findById((byte)2).orElseThrow();
//
//        var product = Product.builder()
//                .name("iPhone 16 Pro")
//                .price(BigDecimal.valueOf(1000.00))
//                .description("iPhone 16 Pro")
//                .category(category)
//                .build();

//        category.addProduct(product);
//        categoryRepository.save(category);
//        productRepository.save(product);

        var user = userRepository.findById(2L).orElseThrow();




    }
}
