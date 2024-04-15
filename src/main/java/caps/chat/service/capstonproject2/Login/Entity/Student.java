package caps.chat.service.capstonproject2.Login.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    public String stuId;

    public String stuPwd;

    public String StuName;

    public String StuImg;
}