package caps.chat.service.capstonproject2.Global.Exception;

import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class IdNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new IdNotFoundException();

    private IdNotFoundException(){
        super(ErrorCode.STUDENT_NOTFOUND);
    }
}
