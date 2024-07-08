package caps.chat.service.capstonproject2.Domain.Member.Security.Service;

import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import caps.chat.service.capstonproject2.Domain.Member.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByStuName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " 학생을 찾을 수 없습니다!"));

        return new User(student.getStuName(), student.getStuPwd(), Collections.emptyList());
    }
}
