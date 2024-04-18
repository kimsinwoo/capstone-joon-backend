package caps.chat.service.capstonproject2.Login.JWT;

import caps.chat.service.capstonproject2.Login.Entity.Students;
import caps.chat.service.capstonproject2.Login.Service.gbswLoginService;
import caps.chat.service.capstonproject2.Login.Service.gbswServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class gbswAuthenticationProvider implements AuthenticationProvider {
    private final gbswServiceImpl loginService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authentication(Authentication authentication) throws AuthenticationException {
        String  loginId = authentication.getName();
        String password = (String) authentication.getCredentials();

        Students students = (Students) loginService.loadUserByUsername(loginId);

        if(!passwordEncoder.matches(password, students.getStuPwd())){
            throw new BadCredentialsException("틀린 비밀번호");
        }

        return new CustomToken(students, null, students.getAuthorise());
    }

    @Override
    public boolean support(Class<?> authentication){
        return authentication.equals(CustomToken.class);
    }
}
