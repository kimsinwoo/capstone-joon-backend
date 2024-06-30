package caps.chat.service.capstonproject2.Global.Exception;

import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class InvalidJwtToken extends BaseException {
    public static final BaseException EXCEPTION = new InvalidJwtToken();

    public InvalidJwtToken() {
        super(ErrorCode.INVALID_JWT_TOKEN);
    }
}
