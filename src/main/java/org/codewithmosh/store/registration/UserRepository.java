package org.codewithmosh.store.registration;

public interface UserRepository {
    void save(User user);
    User findByEmail(String username);
}
