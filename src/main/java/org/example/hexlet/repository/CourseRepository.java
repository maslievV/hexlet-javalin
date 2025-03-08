package org.example.hexlet.repository;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static List<Course> entities = new ArrayList<>();

    public static void save(Course course) {
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        return entities.stream()
                .filter(c -> c.getName().startsWith(term))
                .toList();
    }

    public static Course find(Long id) {
        return entities.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public static List<Course> getEntities() {
        return entities;
    }

}
