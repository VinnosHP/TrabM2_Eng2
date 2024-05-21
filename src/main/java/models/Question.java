package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private int questionPk;
    private int userPk;
    private String questionText;
}
