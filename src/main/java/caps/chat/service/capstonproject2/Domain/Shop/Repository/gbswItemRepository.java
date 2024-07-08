package caps.chat.service.capstonproject2.Domain.Shop.Repository;

import caps.chat.service.capstonproject2.Domain.Shop.Entity.gbswItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface gbswItemRepository extends JpaRepository<gbswItem, Long> {
    List<gbswItem> findByCategory(String category);
}
