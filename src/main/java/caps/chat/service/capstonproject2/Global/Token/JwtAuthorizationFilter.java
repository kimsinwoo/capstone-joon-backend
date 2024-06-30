package caps.chat.service.capstonproject2.Global.Token;

import caps.chat.service.capstonproject2.Domain.Member.Entity.PrincipalDetails;
import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import caps.chat.service.capstonproject2.Domain.Member.Repository.StudentRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;


public class JwtAuthorizationFilter extends BasicAuthenticationFilter {


    private StudentRepository studentRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, StudentRepository studentRepository){
        super(authenticationManager);
        this.studentRepository = studentRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException, IOException {
        String jwtHeader = request.getHeader("Authorization");

        // header가 있는지 확인
        if(jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
            System.out.println("header 미통과");
            chain.doFilter(request, response);
            return;
        }

        String jwtToken = jwtHeader.replace(JwtProperties.TOKEN_PREFIX, "");
        Long id = JWT.require(Algorithm.HMAC256(JwtProperties.SECRET_KEY))
                .build()
                .verify(jwtToken)
                .getClaim("id")
                .asLong();
        System.out.println("서명 실행");

        // 서명이 정상적으로 됨
        if(id != null) {
            System.out.println("서명 통과");
            Student student = studentRepository.findById(id).get();
            System.out.println("testUser = " + student);
            PrincipalDetails principalDetails = new PrincipalDetails();

            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());

            // 세션에 강제 등록
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }


    }
}
