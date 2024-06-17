package caps.chat.service.capstonproject2.Shop.Repository;

import caps.chat.service.capstonproject2.Shop.Entity.gbswItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface gbswItemRepository extends JpaRepository<gbswItem, Long> {
    Optional<gbswItem> findById(Long id);
}
