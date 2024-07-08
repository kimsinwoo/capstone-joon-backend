package caps.chat.service.capstonproject2.Global.Exception;

import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class IncorrectPwd extends BaseException {
    public static final BaseException EXCEPTION = new IncorrectPwd();

    private IncorrectPwd(){
        super(ErrorCode.INCORRECT_PWD);
    }

}
