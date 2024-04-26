package caps.chat.service.capstonproject2.JwtLogin.Controller;

import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import caps.chat.service.capstonproject2.JwtLogin.Repository.gbswStudentsRepository;
import caps.chat.service.capstonproject2.JwtLogin.Service.gbswLoginService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gbsw")
@Slf4j
public class gbswLoginController {
    private final gbswStudentsRepository repository;
    private final gbswLoginService service;
    @GetMapping("/login")
    public Student findStudent(@RequestParam("stuId") String stuId){
        return (Student) service.loadUserByUsername(stuId);
    }

    @PutMapping("/edit")
    public Student editStudentPw(){

    }
}
