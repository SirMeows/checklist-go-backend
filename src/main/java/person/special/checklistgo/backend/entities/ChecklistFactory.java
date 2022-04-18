package person.special.checklistgo.backend.entities;

public class ChecklistFactory {
    public static Checklist create(Long id, String name) {
        var cl = new Checklist();
        cl.setName(name);
        cl.setId(id);
        return cl;
    }

    public static Checklist create(String name) {
        var cl = new Checklist();
        cl.setName(name);
        return cl;
    }
}
