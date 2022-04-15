package person.special.checklistgo.backend.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.entities.ListItem;
import person.special.checklistgo.backend.repositories.ChecklistRepository;
import java.util.Map;

@AllArgsConstructor
@Service
public class ChecklistService {
    private ChecklistRepository checklistRepository;

    private LineItemService lineItemService;

    public Map<Long, Checklist> getChecklists() {
        return checklistRepository.findAllMap();
    }

    public Checklist getChecklist(Long id) {
        return checklistRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"List with id '"+id+"' not found"));
    }

    public Checklist addCheckList(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public Checklist editChecklist(Long id, Checklist checklist) {
        checklist.setId(id);
        return checklistRepository.save(checklist);
    }

    public void deleteChecklist(Long id) {
        checklistRepository.delete(checklistRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"List with id '"+id+"' not found")));
        System.out.println("List with id '"+id+"' deleted");
    }

    public Checklist addItemToChecklist(ListItem item, Long listId) {


        return  null;
    }
}
