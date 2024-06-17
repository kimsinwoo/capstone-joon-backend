package caps.chat.service.capstonproject2.Shop.Dto;

import caps.chat.service.capstonproject2.JwtLogin.Entity.Student;
import caps.chat.service.capstonproject2.Shop.Entity.gbswItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

public class ItemDto {
    Student student = new Student();
    @Data
    @NoArgsConstructor @AllArgsConstructor
    public static class ItemRequest {
        String title;
        Student student;
        int price;
    }

    @Data
    @NoArgsConstructor @AllArgsConstructor
    public static class ItemResponse {
        String title;
        String stuName;

        public ItemResponse(Student student, gbswItem item){
            this.title = item.getTitle();
            this.stuName = student.getStuName();

        }

    }
}
