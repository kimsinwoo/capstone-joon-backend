package caps.chat.service.capstonproject2.JwtLogin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Student {
    @Id
    private String stuId;

    @Column(nullable = false)
    private String stuPwd;

    @Column(nullable = false)
    private String stuName;
    
}
