package caps.chat.service.capstonproject2.JwtLogin.Repository;

import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface gbswStudentsRepository extends JpaRepository<Student, String> {
    Optional<Student> findAllByStuId(String stuId);
}
