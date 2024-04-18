package caps.chat.service.capstonproject2.Shop.Controller;


import caps.chat.service.capstonproject2.Shop.Repository.gbswItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class gbswShopController {
    private final gbswItemRepository itemRepository;

    @GetMapping("/detail/{id}")
    public String detail(){
        ;
    }
}
