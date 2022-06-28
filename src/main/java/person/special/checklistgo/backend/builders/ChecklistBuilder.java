package person.special.checklistgo.backend.builders;

import lombok.Setter;
import person.special.checklistgo.backend.entities.Checklist;

@Setter
public class ChecklistBuilder {

    private Checklist checklist;

    private ChecklistBuilder() {
    }

    public static ChecklistBuilder create() {
        var clBuilder = new ChecklistBuilder();
        var checklist = new Checklist();
        clBuilder.setChecklist(checklist);
        return clBuilder;
    }

    public ChecklistBuilder addName(String name) {
        checklist.setName(name);
        return this;
    }

    public ChecklistBuilder addId(Long id) {
        checklist.setId(id);
        return this;
    }

    public Checklist build() {
        var temp = checklist;
        checklist = null;
        return temp;
    }
}
