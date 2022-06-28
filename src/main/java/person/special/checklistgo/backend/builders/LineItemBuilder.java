package person.special.checklistgo.backend.builders;

import lombok.Setter;
import person.special.checklistgo.backend.entities.LineItem;

@Setter
public class LineItemBuilder {



    private LineItem lineItem;

    private LineItemBuilder() {
    }

    public static LineItemBuilder create() {
        var liBuilder = new LineItemBuilder();
        var lineItem = new LineItem();
        liBuilder.setLineItem(lineItem);
        return liBuilder;
    }

    public LineItemBuilder addId(Long id) {
        lineItem.setId(id);
        return this;
    }

    public LineItemBuilder addDescription(String description) {
        lineItem.setDescription(description);
        return this;
    }

    public LineItemBuilder addIsActive(boolean isActive) {
        lineItem.setActive(isActive);
        return this;
    }

    public LineItem build() {
        var temp = lineItem;
        lineItem = null;
        return temp;
    }
}
