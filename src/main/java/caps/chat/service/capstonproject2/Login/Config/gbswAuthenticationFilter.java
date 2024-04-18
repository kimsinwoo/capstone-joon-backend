package caps.chat.service.capstonproject2.Login.Config;

import caps.chat.service.capstonproject2.Login.Dto.StudentLoginDto;
import caps.chat.service.capstonproject2.Login.JWT.CustomToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class gbswAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private ObjectMapper objectMapper = new ObjectMapper();

    public gbswAuthenticationFilter(){
        super(new AntPathRequestMatcher("/gbsw/students/login"));
    }
    @Override
    public Authentication authentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException, IOException, ServletException {
        if (!isPost(request)){
            throw new IllegalStateException("Authentication is not supported");
        }

        StudentLoginDto loginDto = objectMapper.readValue(request.getReader(), StudentLoginDto.class);

        if (!StringUtils.hasLength(loginDto.getStuId()) || !StringUtils.hasLength(loginDto.getStuPwd())){
            throw new IllegalArgumentException("로그인 아이디 및 패스워드 비어있음!");
        }

        CustomToken token = new CustomToken(
                loginDto.getStuId(),
                loginDto.getStuPwd()
        );

        Authentication authentication = getAuthenticationManager().authenticate(token);

        return authentication;
    }
    private boolean isPost(HttpServletRequest request){
        if("POST".equals(request.getMethod())){
            return true;
        }
        return false;
    }
}
