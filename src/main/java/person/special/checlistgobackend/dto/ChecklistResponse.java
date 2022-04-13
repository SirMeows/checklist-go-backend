package person.special.checlistgobackend.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import person.special.checlistgobackend.entities.Checklist;
import person.special.checlistgobackend.entities.ListItem;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class ChecklistResponse {

    private Long id;
    private String name;
    private Set<ListItem> listItems;

    public ChecklistResponse(Checklist checklist) {
        this.id = checklist.getId();
        this.name = checklist.getName();
        this.listItems = checklist.getListItems();
    }

    public static List<ChecklistResponse> getChecklistsFromEntities(List<Checklist> checklists) {
        return checklists.stream().map(ChecklistResponse::new).collect(Collectors.toList());
    }

}
