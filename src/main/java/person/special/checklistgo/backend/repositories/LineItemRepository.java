package person.special.checklistgo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.special.checklistgo.backend.entities.LineItem;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {

    default Map<Long, LineItem> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(LineItem::getId, v -> v));
    }
}
