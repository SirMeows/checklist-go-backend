package person.special.checklistgo.backend.dto;

import person.special.checklistgo.backend.entities.Checklist;

public class ListItemRequest {

    private Long id;

    private String description;

    private boolean isChecked;

    private Checklist checklist;
}
