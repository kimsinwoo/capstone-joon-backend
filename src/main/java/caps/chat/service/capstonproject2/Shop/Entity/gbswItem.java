package caps.chat.service.capstonproject2.Shop.Entity;


import jakarta.persistence.*;

@Entity
public class gbswItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, unique = true)
    public String title;
    @Column(nullable = false, unique = true)
    public String imgPath;

    public String stuName;
}
