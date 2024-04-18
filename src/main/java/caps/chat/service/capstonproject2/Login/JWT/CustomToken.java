package caps.chat.service.capstonproject2.Login.JWT;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

import java.util.Collection;

public class CustomToken extends AbstractAuthenticationToken {
    private static final long VersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    @Getter
    private final Object principal;

    @Getter
    private Object credentials;

    // 인증 전 생성자
    public CustomToken(Object principal, Object credentials){
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    // 인증 후 생성자
    public CustomToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities){
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    @Override
    public void setAuthentication(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated,  "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials(){
        super.eraseCredentials();
        this.credentials = null;
    }

}
