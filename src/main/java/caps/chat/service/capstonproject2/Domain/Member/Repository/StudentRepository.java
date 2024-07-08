package caps.chat.service.capstonproject2.Domain.Member.Repository;

import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStuId(Long stuId);
    boolean existsByStuId(Long stuId);
    boolean existsByStuName(String stuName);
    Student findStudentsByStuName(String stuName);

    Optional<Student> findByStuName(String stuName);

    Student findOneWithAuthoritiesByStuName(String stuName);
}
