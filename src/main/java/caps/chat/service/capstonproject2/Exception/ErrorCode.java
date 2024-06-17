package caps.chat.service.capstonproject2.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATE_ID(HttpStatus.CONFLICT, "해당 아이디가 존재합니다."),
    INCORRECT_PWD(HttpStatus.UNAUTHORIZED, "비밀번호가 알맞지 않습니다."),
    STUDENT_NOTFOUND(HttpStatus.NOT_FOUND, "해당 학생 아이디가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;
}
