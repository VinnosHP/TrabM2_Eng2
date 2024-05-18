package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final int user_pk;
    private String name;
    private String email;
    private String password;

    public User(int user_pk, String name, String email, String password) {
        this.user_pk = user_pk;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}