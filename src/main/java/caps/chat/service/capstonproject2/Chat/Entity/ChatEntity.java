package caps.chat.service.capstonproject2.Chat.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
public class ChatEntity {
    @Id
    private String roomId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Timestamp time;
}
