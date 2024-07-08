package caps.chat.service.capstonproject2.Domain.Member.Controller;


import caps.chat.service.capstonproject2.Domain.Member.Dto.StudentRequestDto;
import caps.chat.service.capstonproject2.Domain.Member.Dto.StudentResponseDto;
import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import caps.chat.service.capstonproject2.Domain.Member.Security.Util.JwtUtil;
import caps.chat.service.capstonproject2.Domain.Member.Service.StudentLoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Tag(name = "로그인 회원가입", description = "로그인 회원가입 API")
@RequestMapping("/gbsw/students")
public class StudentController {
    private final StudentLoginService StudentService;

    private final JwtUtil jwtUtil;


    @PostMapping("/signUp")
    public ResponseEntity<StudentResponseDto> SignUp(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(StudentService.signUp(student));
    }
    @PostMapping("/signIn")
    public ResponseEntity<StudentResponseDto> login(@RequestBody StudentRequestDto.SignInDto SignIn){
        StudentResponseDto responseDto = StudentService.signIn(SignIn);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/find/{stuName}")
    public Student findByName(String name){
        return StudentService.findByName(name);
    }

    @GetMapping("/find")
    public  List<Student> findUser() {
        return StudentService.find();
    }

}
