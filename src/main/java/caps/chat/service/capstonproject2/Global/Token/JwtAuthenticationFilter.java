package caps.chat.service.capstonproject2.Global.Token;

import caps.chat.service.capstonproject2.Domain.Member.Entity.PrincipalDetails;
import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private AuthenticationManager authenticationManager;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    // "/login" 요청시 로그인 시도를 위해 동작하는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("로그인 시도중");

        // username, pwd를 받아서 authenticationManager로 로그인 시도를 하면 PrincipalDetailsService가 호출 loadUserByUsername 함수 실
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            Student student = objectMapper.readValue(request.getInputStream(), Student.class);
            System.out.println("student = " + student);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(student.getStuName(), student.getStuPwd());
            //PrincipalDetailsService의 loadUserByUsername()가 실행
            //DB에 있는 name과 pwd가 일치하면 authentication이 리턴됌.
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

            // authentication이 세션에 저장됌, 세션 굳이? 권한 관리를 시큐리티가 대신 해주기때문에 편하려고 세션 저장함.
            // JWT 토큰 사용하며 세션을 만들 이유는 없지만 권한처리때문에 session에 넣음
            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    // attemptAuthentication 성공시 -> successfulAuth 실행 됌. 여기서 JWT 만들어서 응답하자.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("로그인 성공");
        PrincipalDetails principal = (PrincipalDetails) authResult.getPrincipal();
        String jwtToken = JWT.create()
                .withSubject("톡톡토큰")
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRE_TIME))
                .withClaim("id", principal.getStudent().getStuId())
                .withClaim("name", principal.getUsername())
                .sign(Algorithm.HMAC256(JwtProperties.SECRET_KEY));

        response.setHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException, ServletException {
        System.out.println("로그인 실패");
        super.unsuccessfulAuthentication(request, response, failed);
    }
}

