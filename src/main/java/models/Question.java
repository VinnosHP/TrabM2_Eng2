package models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Question {
    private int questionPk;
    private int userPk;
    private String questionText;
}
