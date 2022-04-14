package person.special.checklistgo.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import person.special.checklistgo.backend.dto.ChecklistRequest;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.entities.ListItem;
import person.special.checklistgo.backend.repositories.ChecklistRepository;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ChecklistService {
    private ChecklistRepository checklistRepository;

    public Map<Long, Checklist> getChecklists() {
        return checklistRepository.findAllMap();
    }

    public Checklist getChecklist(Long id) {
        return checklistRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"List with id '"+id+"' not found"));
    }

    public Checklist addCheckList(ChecklistRequest body) {
        return checklistRepository.save(new Checklist(body));
    }

    public Checklist editChecklist(Long id, ChecklistRequest body) {
        Checklist clToEdit = new Checklist(body);
        clToEdit.setId(id);
        return checklistRepository.save(clToEdit);
    }

    public void deleteChecklist(Long id) {
        checklistRepository.delete(checklistRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"List with id '"+id+"' not found")));
        System.out.println("List with id '"+id+"' deleted");
    }

    public List<ListItem> addItemToCheckList() {


        return  null;
    }
}
