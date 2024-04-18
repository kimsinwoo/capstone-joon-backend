package caps.chat.service.capstonproject2.Login.Dto;

import lombok.Getter;

@Getter
public enum StudentRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;
    StudentRole(String value){
        this.value = value;
    }

}
