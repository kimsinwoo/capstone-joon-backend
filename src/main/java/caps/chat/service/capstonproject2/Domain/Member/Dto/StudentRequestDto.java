package caps.chat.service.capstonproject2.Domain.Member.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class StudentRequestDto {
    @Getter @Setter
    public class SignUpDto {
        private Long stuId;
        private String stuName;
        private String stuPwd;
        private String stuPhoneNum;
        private Integer isDeleted;
        private LocalDateTime createAt;
    }


    @Getter @Setter
    public static class SignInDto{
        public static SignInDto builder;
        private Long stuId;
        private String stuPwd;
    }

}
