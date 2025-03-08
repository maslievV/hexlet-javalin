package org.example.hexlet.dto.users;

import java.util.Map;
import java.util.List;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BuildUserPage {
    private String name;
    private String email;
    Map<String, List<ValidationError<Object>>> errors;
}
