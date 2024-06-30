package caps.chat.service.capstonproject2.Domain.Shop.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class ItemRequestDto {
    @NotBlank(message = "유저아이디를 적어주세요.")
    private Long stuId;

    @NotBlank(message = "제목을 적어주세요.")
    private String title;

    @NotBlank(message = "가격을 적어주세요.")
    private Integer price;

    @NotBlank(message = "카테고리를 선택해주세요")
    private String category;

    @NotBlank(message = "상품 설명을 적어주세요")
    private String explanation;

    @NotBlank(message = "이미지 파일을 삽입해 주세요")
    private String imgPath;

}
