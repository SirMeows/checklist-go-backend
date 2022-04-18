package person.special.checklistgo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import person.special.checklistgo.backend.entities.Checklist;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LineItemResponse {

    private Long id;

    private String description;

    private boolean isChecked;
}
