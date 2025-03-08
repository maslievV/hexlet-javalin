package org.example.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

import io.javalin.validation.ValidationError;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BuildCoursePage {
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;
}
