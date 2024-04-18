package caps.chat.service.capstonproject2.Login.Service;

import caps.chat.service.capstonproject2.Login.Dto.StudentLoginDto;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface gbswLoginService {
    public String singIn(StudentLoginDto loginDto) throws IOException;
}
