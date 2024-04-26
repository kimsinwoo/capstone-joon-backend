package caps.chat.service.capstonproject2.JwtLogin.Service;

import caps.chat.service.capstonproject2.JwtLogin.Dto.Role;
import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import caps.chat.service.capstonproject2.JwtLogin.Repository.gbswStudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class gbswLoginService implements UserDetailsService {
    private final gbswStudentsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String stuId) throws UsernameNotFoundException{
        Optional<Student> student = this.repository.findAllByStuId(stuId);

        if(student.isEmpty()){
            throw new UsernameNotFoundException("해당 학생이 존재하지 않음!!");
        }
        Student student1 = student.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(stuId)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else {
            authorities.add(new SimpleGrantedAuthority(Role.STUDENT.getValue()));
        }
        return new User(student1.getStuId(), student1.getStuPwd(), authorities);
    }




}
