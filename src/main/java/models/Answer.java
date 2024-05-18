package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private final int answer_pk;
    private final int question_pk;
    private final int user_answer_pk;
    private String answer_text;

    public Answer(int answer_pk, int question_pk, int user_answer_pk, String answer_text) {
        this.answer_pk = answer_pk;
        this.question_pk = question_pk;
        this.user_answer_pk = user_answer_pk;
        this.answer_text = answer_text;
    }
}
