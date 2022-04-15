package person.special.checklistgo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChecklistRequest {

    private Long id;

    private String name;

    private Map<Long, ListItemResponse> listItems;
}
