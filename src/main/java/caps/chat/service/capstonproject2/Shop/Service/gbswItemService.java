package caps.chat.service.capstonproject2.Shop.Service;


import caps.chat.service.capstonproject2.Shop.Dto.ItemDto;
import caps.chat.service.capstonproject2.Shop.Entity.gbswItem;
import caps.chat.service.capstonproject2.Shop.Repository.gbswItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;

@Service @RequiredArgsConstructor
public class gbswItemService {
    private final gbswItemRepository itemRepository;
    public void createBoard(ItemDto.ItemRequest itemDto) throws Exception{
        gbswItem item = new gbswItem(itemDto);
        itemRepository.save(item);
    }


}
