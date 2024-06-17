package caps.chat.service.capstonproject2.JwtLogin.Controller;


import caps.chat.service.capstonproject2.JwtLogin.Dto.StudentRequestDto;
import caps.chat.service.capstonproject2.JwtLogin.Dto.StudentResponseDto;
import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import caps.chat.service.capstonproject2.JwtLogin.Service.StudentLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/gbsw/Students")
public class StudentLoginController {
    private final StudentLoginService StudentService;

    @PostMapping("/signUp")
    public ResponseEntity<StudentResponseDto> SignUp(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(StudentService.signUp(student));
    }
    @PostMapping("/signIn")
    public ResponseEntity<StudentResponseDto> login(@RequestBody StudentRequestDto.SignInDto SignIn){
        return ResponseEntity.status(HttpStatus.OK)
                .body(StudentService.signIn(SignIn));
    }

}
