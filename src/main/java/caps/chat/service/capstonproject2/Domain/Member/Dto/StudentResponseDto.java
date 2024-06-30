package caps.chat.service.capstonproject2.Domain.Member.Dto;

import caps.chat.service.capstonproject2.Global.Base.Dto.ResponseDto;
import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StudentResponseDto extends ResponseDto {

    private final Long stuId;
    private final String stuName;


    @Builder
    public StudentResponseDto(Integer isDeleted, LocalDateTime createAt, LocalDateTime updateAt, Long stuId, String stuName){
        super(isDeleted, createAt, updateAt);
        this.stuId = stuId;
        this.stuName = stuName;
    }

    public static StudentResponseDto from(Student student){
        return StudentResponseDto.builder()
                .isDeleted(student.getIsDeleted())
                .createAt(student.getCreateAt())
                .updateAt(student.getUpdateAt())
                .stuId(student.getStuId())
                .stuName(student.getStuName())
                .build();
    }

}
