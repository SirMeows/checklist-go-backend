package person.special.checklistgo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.special.checklistgo.backend.entities.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
}
