package repositories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserDTO {
    @JsonProperty("user_pk")
    private Integer userPk;

    @JsonProperty("picture_id")
    private Integer pictureId;

    @JsonProperty("name")
    private String userName;

    @JsonProperty("email")
    private String userEmail;

    @JsonProperty("password")
    private String userPassword;
}
