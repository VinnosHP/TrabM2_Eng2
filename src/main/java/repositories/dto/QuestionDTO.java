package repositories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class QuestionDTO {
    @JsonProperty("question_pk")
    private Integer questionPk;

    @JsonProperty("user_pk")
    private Integer userPk;

    @JsonProperty("question_text")
    private String questionText;
}
