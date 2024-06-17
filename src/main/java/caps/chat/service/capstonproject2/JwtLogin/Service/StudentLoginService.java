package caps.chat.service.capstonproject2.JwtLogin.Service;

import caps.chat.service.capstonproject2.Exception.DuplicateId;
import caps.chat.service.capstonproject2.Exception.IdNotFoundException;
import caps.chat.service.capstonproject2.Exception.IncorrectPwd;
import caps.chat.service.capstonproject2.JwtLogin.Dto.StudentRequestDto;
import caps.chat.service.capstonproject2.JwtLogin.Dto.StudentResponseDto;
import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import caps.chat.service.capstonproject2.JwtLogin.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class StudentLoginService{
    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public StudentResponseDto signUp(Student student){
        if(studentRepository.existsByStuId(student.getStuId())){
            throw DuplicateId.EXCEPTION;
        }
        String passwd = student.getStuPwd();
        String encodePwd = passwordEncoder.encode(passwd);
        student.setStuPwd(encodePwd);

        return StudentResponseDto.from(studentRepository.save(student));
    }


    public StudentResponseDto signIn(StudentRequestDto.SignInDto SignIn) {
        boolean isValid = false;
        Student loggedStu = studentRepository.findByStuId(SignIn.getStuId());
        if(loggedStu != null){
            isValid = BCrypt.checkpw(SignIn.getStuPwd(), loggedStu.getStuPwd());
        }else{
            throw IdNotFoundException.EXCEPTION;
        }
        if (isValid){
            return StudentResponseDto.from(loggedStu);
        }else {
            throw IncorrectPwd.EXCEPTION;
        }
    }



}
