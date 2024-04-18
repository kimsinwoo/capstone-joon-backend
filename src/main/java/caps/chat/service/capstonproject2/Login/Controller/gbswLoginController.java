package caps.chat.service.capstonproject2.Login.Controller;

import caps.chat.service.capstonproject2.Login.Dto.StudentLoginDto;
import caps.chat.service.capstonproject2.Login.Service.gbswLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/gbsw/students")
@Controller
public class gbswLoginController {

    private final gbswLoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody StudentLoginDto request) throws Exception{
        return ResponseEntity.ok().body(loginService.signIn(request));
    }
}
