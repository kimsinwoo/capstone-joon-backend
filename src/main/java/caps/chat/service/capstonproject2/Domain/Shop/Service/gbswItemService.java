package caps.chat.service.capstonproject2.Domain.Shop.Service;


import caps.chat.service.capstonproject2.Domain.Member.Entity.Student;
import caps.chat.service.capstonproject2.Domain.Member.Repository.StudentRepository;
import caps.chat.service.capstonproject2.Domain.Shop.Dto.ItemRequestDto;
import caps.chat.service.capstonproject2.Domain.Shop.Dto.ItemResponseDto;
import caps.chat.service.capstonproject2.Domain.Shop.Entity.gbswItem;
import caps.chat.service.capstonproject2.Domain.Shop.Repository.gbswItemRepository;
import caps.chat.service.capstonproject2.Global.Exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class gbswItemService {
    private final gbswItemRepository itemRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public gbswItemService(gbswItemRepository itemRepository, StudentRepository studentRepository){
        this.itemRepository = itemRepository;
        this.studentRepository = studentRepository;
    }

    public ItemResponseDto create(@RequestBody ItemRequestDto requestDto){
        Student student = studentRepository.findByStuId(requestDto.getStuId());

        gbswItem item = gbswItem.builder()
                .student(student)
                .category(requestDto.getCategory())
                .title(requestDto.getTitle())
                .price(requestDto.getPrice())
                .itemImgPath(requestDto.getImgPath())
                .explanation(requestDto.getExplanation())
                .build();

        gbswItem save = itemRepository.save(item);

        return ItemResponseDto.from(save);
    }

    public Optional<gbswItem> findById(Long Id){
        Optional<gbswItem> item = itemRepository.findById(Id);

        return item;
    }

    public List<ItemResponseDto> findAll(){
        List<gbswItem> items = itemRepository.findAll();

        return items.stream()
                .map(ItemResponseDto::from)
                .collect(Collectors.toList());
    }

    public List<ItemResponseDto> findCategory(String Category){
        List<gbswItem> items = itemRepository.findByCategory(Category);

        if (items.isEmpty()){
            throw ItemNotFoundException.EXCEPTION;
        }

        return items.stream()
                .map(ItemResponseDto::from)
                .collect(Collectors.toList());
    }

}
