package org.example.hexlet.repository;

import org.example.hexlet.dto.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static List<User> entities = new ArrayList<User>();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<User> search(String term) {
        return entities.stream()
                .filter(u -> u.getUsername().startsWith(term))
                .toList();
    }

    public static Optional<User> find (Long id) {
        return entities.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public static List<User> getEntities() {
        return entities;
    }
}
