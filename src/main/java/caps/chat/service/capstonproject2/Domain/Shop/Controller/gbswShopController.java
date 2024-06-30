package caps.chat.service.capstonproject2.Domain.Shop.Controller;

import caps.chat.service.capstonproject2.Domain.Shop.Dto.ItemRequestDto;
import caps.chat.service.capstonproject2.Domain.Shop.Entity.gbswItem;
import caps.chat.service.capstonproject2.Domain.Shop.Dto.ItemResponseDto;
import caps.chat.service.capstonproject2.Domain.Shop.Service.gbswItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Tag(name = "상품등록", description = "상품등록 API")
@RequestMapping("/gbsw/shop")
public class gbswShopController {
    private final gbswItemService itemService;

    @Autowired
    public gbswShopController(gbswItemService itemService){
        this.itemService = itemService;
    }



    @PostMapping("/create")
    public ResponseEntity<ItemResponseDto> create(@RequestBody ItemRequestDto requestDto) {
        ItemResponseDto responseDto = itemService.create(requestDto);
        return ResponseEntity.ok(responseDto);
    }


    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> getAllItems(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.findAll());
    }

    @GetMapping("/ItemId/{Id}")
    public ResponseEntity<Optional<gbswItem>> getItemByName(@PathVariable("Id") Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.findById(id));
    }

    @GetMapping("/Category/{category}")
    public ResponseEntity<List<ItemResponseDto>> getCategoryById(@PathVariable("category") String category){
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.findCategory(category));
    }
}

