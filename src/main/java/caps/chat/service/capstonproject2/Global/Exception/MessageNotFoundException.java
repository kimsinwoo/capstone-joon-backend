package caps.chat.service.capstonproject2.Global.Exception;

import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class MessageNotFoundException extends BaseException {
    public static BaseException EXCEPTION = new MessageNotFoundException();

    private MessageNotFoundException() {
        super(ErrorCode.MESSAGE_NOT_FOUND);
    }
}
