package caps.chat.service.capstonproject2.Global.Exception;

import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class DuplicateId extends BaseException {
    public static final BaseException EXCEPTION = new DuplicateId();

    private DuplicateId(){
        super(ErrorCode.DUPLICATE_ID);
    }
}
