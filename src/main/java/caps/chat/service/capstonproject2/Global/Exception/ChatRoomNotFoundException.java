package caps.chat.service.capstonproject2.Global.Exception;

import caps.chat.service.capstonproject2.Global.Exception.Base.BaseException;

public class ChatRoomNotFoundException extends BaseException {
    public static BaseException EXCEPTION = new ChatRoomNotFoundException();

    private ChatRoomNotFoundException(){
        super(ErrorCode.CHAT_ROOM_NOT_FOUND);
    }
}
