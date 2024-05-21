package web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import repositories.prototype.IPrototype;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerForm implements IPrototype {
    @JsonProperty("answer_pk")
    private Integer answerPk;

    @JsonProperty("user_pk")
    private Integer userPk;

    @JsonProperty("question_pk")
    private Integer questionPk;

    @JsonProperty("answer_text")
    private String answerText;

    @Override
    public AnswerForm clone() {
        return AnswerForm.builder()
                .answerPk(this.answerPk)
                .userPk(this.userPk)
                .questionPk(this.questionPk)
                .answerText(this.answerText)
                .build();
    }
}
