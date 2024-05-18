package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private final int questionPk;
    private final int userPk;
    private String questionText;

    public Question(int questionPk, int userPk, String questionText) {
        this.questionPk = questionPk;
        this.userPk = userPk;
        this.questionText = questionText;
    }
}
