package caps.chat.service.capstonproject2.Exception;

public class IncorrectPwd extends BaseException{
    public static final BaseException EXCEPTION = new IncorrectPwd();

    private IncorrectPwd(){
        super(ErrorCode.INCORRECT_PWD);
    }

}
