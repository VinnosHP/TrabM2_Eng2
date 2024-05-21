package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private int answerPk;
    private int questionPk;
    private int userPk;
    private String answerText;
}
