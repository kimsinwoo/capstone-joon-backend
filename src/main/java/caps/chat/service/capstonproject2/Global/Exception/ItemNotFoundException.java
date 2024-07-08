package caps.chat.service.capstonproject2.Global.Exception;

import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class ItemNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new ItemNotFoundException();

    private ItemNotFoundException(){
        super(ErrorCode.ITEM_NOT_FOUND);
    }
}
