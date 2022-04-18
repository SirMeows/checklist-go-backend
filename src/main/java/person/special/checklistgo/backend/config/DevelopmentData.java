package person.special.checklistgo.backend.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.entities.ChecklistFactory;
import person.special.checklistgo.backend.entities.LineItem;
import person.special.checklistgo.backend.entities.LineItemFactory;
import person.special.checklistgo.backend.repositories.ChecklistRepository;
import person.special.checklistgo.backend.repositories.LineItemRepository;

@AllArgsConstructor
@Profile("!test")
@Component
public class DevelopmentData implements ApplicationRunner {

    ChecklistRepository checklistRepository;

    LineItemRepository lineItemRepository;

    public void createTestData() {
        Checklist cl_1 = ChecklistFactory.create("home improvement");
        Checklist cl_2 = ChecklistFactory.create("groceries");
        Checklist cl_3 = ChecklistFactory.create("todo");

        checklistRepository.save(cl_1);
        checklistRepository.save(cl_2);
        checklistRepository.save(cl_3);

        LineItem li_1 = LineItemFactory.create("desk");
        LineItem li_2 = LineItemFactory.create("curtain");
        LineItem li_3 = LineItemFactory.create("box");

        li_1.setChecklist(cl_1);
        li_2.setChecklist(cl_1);
        li_3.setChecklist(cl_1);

        lineItemRepository.save(li_1);
        lineItemRepository.save(li_2);
        lineItemRepository.save(li_3);
    }
    @Override
    public void run(ApplicationArguments args) {
        createTestData();
    }
}

