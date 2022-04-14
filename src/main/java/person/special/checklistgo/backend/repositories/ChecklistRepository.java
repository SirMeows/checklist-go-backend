package person.special.checklistgo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.special.checklistgo.backend.entities.Checklist;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    default Map<Long, Checklist> findAllMap() {
        return findAll().stream().collect(Collectors.toMap(Checklist::getId, v -> v));
    }
}
