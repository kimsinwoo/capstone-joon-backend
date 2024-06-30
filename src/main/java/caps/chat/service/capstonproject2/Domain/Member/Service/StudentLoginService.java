package caps.chat.service.capstonproject2.Domain.Member.Service;

import caps.chat.service.capstonproject2.Domain.Member.Dto.StudentRequestDto;
import caps.chat.service.capstonproject2.Domain.Member.Dto.StudentResponseDto;
import caps.chat.service.capstonproject2.Global.Exception.DuplicateId;
import caps.chat.service.capstonproject2.Global.Exception.IdNotFoundException;
import caps.chat.service.capstonproject2.Global.Exception.IncorrectPwd;
import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import caps.chat.service.capstonproject2.Domain.Member.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StudentLoginService{
    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public StudentLoginService(@Qualifier("securityConfigEncoder") BCryptPasswordEncoder bCryptPasswordEncoder, StudentRepository studentRepository){
        this.passwordEncoder = bCryptPasswordEncoder;
        this.studentRepository = studentRepository;
    }

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

    public Student findByName(String name) {
        return studentRepository.findStudentsByStuName(name);
    }

    public List<Student> find() {
        return studentRepository.findAll();
    }



}
