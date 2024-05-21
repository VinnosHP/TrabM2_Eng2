package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private final int answerPk;
    private final int questionPk;
    private final int userAnswerPk;
    private String answerText;

    public Answer(int answerPk, int questionPk, int userAnswerPk, String answerText) {
        this.answerPk = answerPk;
        this.questionPk = questionPk;
        this.userAnswerPk = userAnswerPk;
        this.answerText = answerText;
    }
}
