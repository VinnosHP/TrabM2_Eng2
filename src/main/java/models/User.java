package models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class User {
    private int userPk;
    private String name;
    private String email;
    private String password;
}