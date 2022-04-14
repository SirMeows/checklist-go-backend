package person.special.checklistgo.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import person.special.checklistgo.backend.dto.ChecklistRequest;
import person.special.checklistgo.backend.dto.ChecklistResponse;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.repositories.ChecklistRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ChecklistService {
    private ChecklistRepository checklistRepository;

    public List<ChecklistResponse> getChecklists() {
        return ChecklistResponse.getChecklistsFromEntities(checklistRepository.findAll());
    }

    public ChecklistResponse getChecklist(Long id) {
        return new ChecklistResponse(checklistRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"List with id '"+id+"' not found")));
    }

    public ChecklistResponse addCheckList(ChecklistRequest body) {
        Checklist checklist = checklistRepository.save(new Checklist(body));
        return new ChecklistResponse(checklist);
    }

    public ChecklistResponse editChecklist(Long id, ChecklistRequest body) {
        Checklist clToEdit = new Checklist(body);
        clToEdit.setId(id);
        return new ChecklistResponse(checklistRepository.save(clToEdit));
    }

    public void deleteChecklist(Long id) {
        checklistRepository.delete(checklistRepository.getById(id));
    }

    // public List<ListItem> addItemToCheckList()
}
