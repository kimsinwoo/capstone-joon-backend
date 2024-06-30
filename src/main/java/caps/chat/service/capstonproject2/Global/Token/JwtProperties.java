package caps.chat.service.capstonproject2.Global.Token;

import org.springframework.beans.factory.annotation.Value;

public class JwtProperties {

    @Value("${jwt.secretKey}")
    public static String SECRET_KEY;
    public static int EXPIRE_TIME = 6000;
    public static String TOKEN_PREFIX = "Bearer ";
    public static String HEADER_STRING = "Authorization";
}
