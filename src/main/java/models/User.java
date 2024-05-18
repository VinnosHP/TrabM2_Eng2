package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final int userPk;
    private String name;
    private String email;
    private String password;

    public User(int userPk, String name, String email, String password) {
        this.userPk = userPk;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}