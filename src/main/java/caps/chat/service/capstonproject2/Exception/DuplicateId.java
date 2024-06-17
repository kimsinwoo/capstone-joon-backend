package caps.chat.service.capstonproject2.Exception;

public class DuplicateId extends BaseException{
    public static final BaseException EXCEPTION = new DuplicateId();

    private DuplicateId(){
        super(ErrorCode.DUPLICATE_ID);
    }
}
