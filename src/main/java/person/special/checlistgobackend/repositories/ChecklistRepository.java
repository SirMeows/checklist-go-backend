package person.special.checlistgobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.special.checlistgobackend.entities.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
}
