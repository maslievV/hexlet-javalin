package org.example.hexlet.dto.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
