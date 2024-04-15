package caps.chat.service.capstonproject2.Controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Getter
@Setter
public class gbswLoginController {
    @GetMapping("/login")
    private String login(){
        return "login";
    }
}
