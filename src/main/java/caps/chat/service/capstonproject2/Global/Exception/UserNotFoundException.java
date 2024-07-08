package caps.chat.service.capstonproject2.Global.Exception;


import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class UserNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException(){
        super(ErrorCode.STUDENT_NOTFOUND);
    }
}
