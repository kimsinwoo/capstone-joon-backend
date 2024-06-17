package caps.chat.service.capstonproject2.JwtLogin.Dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class StudentRequestDto {
    @Getter
    @Setter
    public class SignUpDto {
        private Long stuId;
        private String stuName;
        private String stuPwd;
    }


    @Getter
    @Setter
    public static class SignInDto{
        private Long stuId;
        private String stuPwd;
    }

}
