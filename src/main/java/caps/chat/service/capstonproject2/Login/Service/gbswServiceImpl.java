package caps.chat.service.capstonproject2.Login.Service;


import caps.chat.service.capstonproject2.Login.Entity.Students;
import caps.chat.service.capstonproject2.Login.Repository.gbswStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class gbswServiceImpl implements UserDetailsService {

    private final gbswStudentRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Students students = repository.findStudentsByStuId(username).orElseThrow(() -> new UsernameNotFoundException("Id not found"));
        return students;
    }
}
