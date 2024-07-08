package caps.chat.service.capstonproject2.Global.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATE_ID(HttpStatus.CONFLICT, "해당 아이디가 존재합니다."),
    INCORRECT_PWD(HttpStatus.UNAUTHORIZED, "비밀번호가 알맞지 않습니다."),
    STUDENT_NOTFOUND(HttpStatus.NOT_FOUND, "해당 학생 아이디가 존재하지 않습니다."),
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 게시물이 존재하지 않습니다."),
    MESSAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "메세지가 존재하지 않습니다."),
    CHAT_ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "채팅방이 존재하지 않습니다."),
    INVALID_JWT_TOKEN(HttpStatus.INTERNAL_SERVER_ERROR, "만료되거나 유효하지 않은 토큰");
    private final HttpStatus httpStatus;
    private final String errorMessage;
}
