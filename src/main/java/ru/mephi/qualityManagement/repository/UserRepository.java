package ru.mephi.qualityManagement.repository;

import ru.mephi.qualityManagement.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

    default void enable(int id, boolean enable) {
        throw new UnsupportedOperationException("Enable for this profile is not supported");
    }
}
