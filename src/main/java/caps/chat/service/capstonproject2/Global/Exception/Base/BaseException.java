package caps.chat.service.capstonproject2.Global.Exception.Base;


import caps.chat.service.capstonproject2.Global.Exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException {
    private final ErrorCode errorCode;
}
