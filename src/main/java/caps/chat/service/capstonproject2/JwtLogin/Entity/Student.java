package caps.chat.service.capstonproject2.JwtLogin.Entity;

import caps.chat.service.capstonproject2.Base.Entity.BaseEntity;
import caps.chat.service.capstonproject2.JwtLogin.Dto.StudentRequestDto;
import caps.chat.service.capstonproject2.Shop.Entity.gbswItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Table(name = "Students")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseEntity {
    @Id
    private Long stuId;

    @Column(nullable = false, length = 20, unique = true)
    private String stuName;

    @Column(nullable = false)
    private String stuPwd;

    private String stuPhoneNum;


    @Override
    public void delete(){
        this.isDeleted = 1;
    }
}
