package caps.chat.service.capstonproject2.JwtLogin.Repository;

import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStuId(Long stuId);
    boolean existsByStuId(Long stuId);

}
