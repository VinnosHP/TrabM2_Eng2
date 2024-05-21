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
public class QuestionForm implements IPrototype {
    @JsonProperty("user_pk")
    private Integer userPk;

    @JsonProperty("question_pk")
    private Integer questionPk;

    @JsonProperty("question_text")
    private String questionText;

    @Override
    public QuestionForm clone() {
        return QuestionForm.builder()
                .questionPk(this.questionPk)
                .userPk(this.userPk)
                .questionText(this.questionText)
                .build();
    }
}
