package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private final int question_pk;
    private final int user_pk;
    private String question_text;

    public Question(int question_pk, int user_pk, String question_text) {
        this.question_pk = question_pk;
        this.user_pk = user_pk;
        this.question_text = question_text;
    }
}
