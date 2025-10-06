package org.codewithmosh.store.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.codewithmosh.store.entities.Address;
import org.codewithmosh.store.entities.User;
import org.codewithmosh.store.repositories.AddressRepository;
import org.codewithmosh.store.repositories.ProfileRepository;
import org.codewithmosh.store.repositories.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;

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
}
