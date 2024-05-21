package repositories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AnswerDTO {
    @JsonProperty("answer_pk")
    private Integer answerPk;

    @JsonProperty("user_pk")
    private Integer userPk;

    @JsonProperty("question_pk")
    private Integer questionPk;

    @JsonProperty("answer_text")
    private String answerText;
}
