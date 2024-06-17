package caps.chat.service.capstonproject2.Base.Dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ResponseDto {
    private final Integer isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDateTime createAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDateTime updateAt;
}
