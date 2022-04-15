package person.special.checklistgo.backend.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.entities.ChecklistFactory;
import person.special.checklistgo.backend.services.ChecklistService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CheckListControllerTest {
    @Autowired
    ModelMapper modelMapper;

    @Mock
    ChecklistService clService;

    CheckListController clController;

    Checklist cl_1;
    Checklist cl_2;

    @BeforeEach
    void setUp() {
        this.clController = new CheckListController(modelMapper, clService);
        cl_1 = ChecklistFactory.create(10L, "name_1");
        cl_2 = ChecklistFactory.create(20L, "name_2");
    }

    @Test
    void getChecklists() {
        Map<Long, Checklist> checkLists = new HashMap<>();

        checkLists.put(cl_1.getId(), cl_1);
        checkLists.put(cl_2.getId(), cl_2);

        Mockito.when(clService.getChecklists()).thenReturn(checkLists);

        var actual = clController.getChecklists();

        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertTrue(actual.containsKey(cl_1.getId()));
        assertEquals("name_1", actual.get(cl_1.getId()).getName());
    }

    @Test
    void getChecklist() {
        Mockito.when(clService.getChecklist(cl_1.getId())).thenReturn(cl_1);

        var actual = clController.getCheckList(cl_1.getId());

        assertNotNull(actual);
        assertEquals("name_1", cl_1.getName());
    }

    @AfterEach
    void tearDown() {
        cl_1 = null;
        cl_2 = null;
    }
}