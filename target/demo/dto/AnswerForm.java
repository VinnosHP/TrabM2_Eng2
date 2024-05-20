package webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerForm {
    @JsonProperty("answer_pk")
    private Integer answerPk;

    @JsonProperty("user_pk")
    private Integer userPk;

    @JsonProperty("question_pk")
    private Integer questionPk;

    @JsonProperty("answer_text")
    private String answerText;
}
