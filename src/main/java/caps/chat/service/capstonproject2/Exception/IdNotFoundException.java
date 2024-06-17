package caps.chat.service.capstonproject2.Exception;

public class IdNotFoundException extends BaseException{
    public static final BaseException EXCEPTION = new IdNotFoundException();

    private IdNotFoundException(){
        super(ErrorCode.STUDENT_NOTFOUND);
    }
}
