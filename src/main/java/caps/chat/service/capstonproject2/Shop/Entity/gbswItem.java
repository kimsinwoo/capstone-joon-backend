package caps.chat.service.capstonproject2.Shop.Entity;


import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class gbswItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    public String title;

    @Column(nullable = false, unique = true)
    public String imgPath;

    @ManyToOne
    @JoinColumn(name = "stuId")
    public Student student;

    @CreationTimestamp
    private Timestamp createDate;
}
