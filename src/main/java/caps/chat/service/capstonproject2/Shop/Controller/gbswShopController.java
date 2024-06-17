package caps.chat.service.capstonproject2.Shop.Controller;

import caps.chat.service.capstonproject2.Shop.Dto.ItemDto;
import caps.chat.service.capstonproject2.Shop.Service.gbswItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gbsw/shop")
public class gbswShopController {
    private final gbswItemService itemService;
    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody ItemDto.ItemRequest itemDto) throws Exception{
        itemService.createBoard(itemDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

