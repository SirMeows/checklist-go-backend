package person.special.checklistgo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChecklistResponse {

    private Long id;

    private String name;

    private Map<Long, LineItemResponse> listItems;
}
