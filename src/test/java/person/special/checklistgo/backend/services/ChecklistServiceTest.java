package person.special.checklistgo.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import person.special.checklistgo.backend.dto.ChecklistRequest;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.repositories.ChecklistRepository;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
class ChecklistServiceTest {

    @Mock
    ChecklistRepository clMockRepository;

    ChecklistService cLService;

    Checklist cl;

    @BeforeEach
    void setUp() {
        cLService = new ChecklistService(clMockRepository);
        cl = new Checklist();
        cl.setName("testName");
    }

    @Test
    void getChecklists() {

        Mockito.when(clMockRepository.findAllMap()).thenReturn(Map.of(
                1L, new Checklist(),
                2L, new Checklist()
        ));
        Map<Long, Checklist> cLists = cLService.getChecklists();
        assertEquals(2, cLists.size());
    }

    @Test
    void deleteChecklist_idExists() {
        var id = 100L;

        Mockito.when(clMockRepository.findById(id)).thenReturn(Optional.of(new Checklist(id, "someName", Collections.emptyMap())));
        cLService.deleteChecklist(id);

        Mockito.verify(clMockRepository).delete(any(Checklist.class));
    }

    @Test
    void deleteChecklist_idDoesNotExist() {
        var id = 200L;

        Exception exception = assertThrows(Exception.class, () -> cLService.deleteChecklist(id));
        assertEquals("404 NOT_FOUND \"List with id '200' not found\"", exception.getMessage());
    }
}