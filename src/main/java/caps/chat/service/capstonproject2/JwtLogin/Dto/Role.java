package caps.chat.service.capstonproject2.JwtLogin.Dto;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    STUDENT("ROLE_STUDENT");

    Role(String val){
        this.value = val;
    }

    private String value;
}
