package caps.chat.service.capstonproject2.Shop.Entity;


import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import caps.chat.service.capstonproject2.Shop.Dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class gbswItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    public String title;

    @Column(nullable = false, unique = true)
    public String itemImgPath;

    @ManyToOne
    @JoinColumn(name = "stuName")
    public Student student;

    @Column(nullable = false, unique = true)
    public int price;

    @CreationTimestamp
    private Timestamp createDate;

    public gbswItem (ItemDto.ItemRequest itemDto){
        this.title = itemDto.getTitle();
        this.price = itemDto.getPrice();
        this.student = itemDto.getStudent();

    }

}
