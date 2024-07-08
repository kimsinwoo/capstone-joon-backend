package caps.chat.service.capstonproject2.Domain.Shop.Entity;


import caps.chat.service.capstonproject2.Global.Base.Entity.BaseEntity;
import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Internal;

import java.util.ArrayList;
import java.util.List;


@Table(name = "Items")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class gbswItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    public String title;

    @Column(nullable = false, name = "category")
    public String category;

    @Column(nullable = false, unique = true)
    public String itemImgPath;

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "stuId")
    public Student student;

    @Column(nullable = false, unique = true)
    public Integer price;

    @Column(nullable = false, unique = true)
    public String explanation;

}
