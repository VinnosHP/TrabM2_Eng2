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
public class QuestionForm {
    @JsonProperty("user_pk")
    private Integer userPk;

    @JsonProperty("question_pk")
    private Integer questionPk;

    @JsonProperty("question_text")
    private String questionText;
}
