package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Course {

    private Long id ;

    @ToString.Include
    private String name;
    private String description;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
