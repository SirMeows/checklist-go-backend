package person.special.checklistgo.backend.builders;

import person.special.checklistgo.backend.entities.LineItem;

public class LineItemFactory {

    public static LineItem create(Long id, String description) {
        var li = new LineItem();
        li.setDescription(description);
        li.setId(id);
        return li;
    }

    public static LineItem create(String description) {
        var li = new LineItem();
        li.setDescription(description);
        return li;
    }
}
