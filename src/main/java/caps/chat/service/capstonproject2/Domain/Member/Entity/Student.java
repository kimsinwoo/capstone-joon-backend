package caps.chat.service.capstonproject2.Domain.Member.Entity;

import caps.chat.service.capstonproject2.Domain.Shop.Entity.gbswItem;
import caps.chat.service.capstonproject2.Global.Base.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Table(name = "Students")
@Entity
@Setter
@Getter
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

    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private GbswRole authority;

    @Builder.Default
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<gbswItem> items = new ArrayList<>();

}
