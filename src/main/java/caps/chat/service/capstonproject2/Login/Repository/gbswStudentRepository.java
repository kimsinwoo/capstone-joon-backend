package caps.chat.service.capstonproject2.Login.Repository;


import caps.chat.service.capstonproject2.Login.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface gbswStudentRepository extends JpaRepository<Students, String> {
    Optional<Students> findStudentsByStuId(String stuId);
}
