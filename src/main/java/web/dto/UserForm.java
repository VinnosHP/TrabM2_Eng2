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
public class UserForm implements IPrototype {
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

    @Override
    public UserForm clone() {
        return UserForm.builder()
                .userPk(this.userPk)
                .pictureId(this.pictureId)
                .userName(this.userName)
                .userEmail(this.userEmail)
                .userPassword(this.userPassword)
                .build();
    }
}
