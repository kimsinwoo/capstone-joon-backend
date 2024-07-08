package caps.chat.service.capstonproject2.Domain.Shop.Dto;

import caps.chat.service.capstonproject2.Global.Base.Dto.ResponseDto;
import caps.chat.service.capstonproject2.Domain.Shop.Entity.gbswItem;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
public class ItemResponseDto extends ResponseDto {

    private final Long id;
    private final String title;
    private final String imgPath;
    private final String Category;
    private final String explanation;

    @Builder
    public ItemResponseDto(Integer isDeleted, LocalDateTime createAt, LocalDateTime updateAt, Long id, String title, String imgPath, String category, String explanation){
        super(isDeleted, createAt, updateAt);
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.Category = category;
        this.explanation = explanation;
    }

    public static ItemResponseDto from(gbswItem item){
        return ItemResponseDto.builder()
                .isDeleted(item.getIsDeleted())
                .createAt(item.getCreateAt())
                .updateAt(item.getUpdateAt())
                .id(item.getId())
                .title(item.getTitle())
                .imgPath(item.getItemImgPath())
                .category(item.getCategory())
                .explanation(item.getExplanation())
                .build();
    }
}
