package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int userPk;
    private String name;
    private String email;
    private String password;
}