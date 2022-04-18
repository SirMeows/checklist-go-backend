package person.special.checklistgo.backend.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.entities.LineItem;
import person.special.checklistgo.backend.repositories.LineItemRepository;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class LineItemService {

    private LineItemRepository lineItemRepository;

    public Map<Long, LineItem> getLineItems() {
        return lineItemRepository.findAllMap();
    }

    public LineItem getLineItem(Long id) {
        return lineItemRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Item with id '"+id+"' not found"));
    }

    public LineItem addLineItem(LineItem lineItem, Checklist checklist) {
        lineItem.setChecklist(checklist);
        return lineItemRepository.save(lineItem);
    }

    public LineItem editLineItem(Long id, LineItem lineItem) {
        lineItem.setId(id);
        return lineItemRepository.save(lineItem);
    }

    public void deleteLineItem(Long id) {
        lineItemRepository.delete(lineItemRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Item with id '"+id+"' not found")));
        System.out.println("Item with id '"+id+"' deleted");
    }
}
