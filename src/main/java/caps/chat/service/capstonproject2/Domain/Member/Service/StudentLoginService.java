package caps.chat.service.capstonproject2.Domain.Member.Service;

import caps.chat.service.capstonproject2.Domain.Member.Dto.StudentRequestDto;
import caps.chat.service.capstonproject2.Domain.Member.Dto.StudentResponseDto;
import caps.chat.service.capstonproject2.Domain.Member.Security.Util.JwtUtil;
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

    private final JwtUtil jwtUtil;

    @Autowired
    public StudentLoginService(@Qualifier("securityConfigEncoder") BCryptPasswordEncoder bCryptPasswordEncoder, StudentRepository studentRepository, JwtUtil jwtUtil){
        this.passwordEncoder = bCryptPasswordEncoder;
        this.studentRepository = studentRepository;
        this.jwtUtil = jwtUtil;
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
        Student student = studentRepository.findByStuId(SignIn.getStuId());

        if (student == null) {
            throw IdNotFoundException.EXCEPTION;
        }

        if (!passwordEncoder.matches(SignIn.getStuPwd(), student.getStuPwd())) {
            throw IncorrectPwd.EXCEPTION;
        }

        String token = jwtUtil.generateToken(student.getStuName());
        return new StudentResponseDto(
                student.getIsDeleted(),
                student.getUpdateAt(),
                student.getCreateAt(),
                student.getStuId(),
                student.getStuName(),
                token);
    }

    public Student findByName(String name) {
        return studentRepository.findStudentsByStuName(name);
    }

    public List<Student> find() {
        return studentRepository.findAll();
    }



}
