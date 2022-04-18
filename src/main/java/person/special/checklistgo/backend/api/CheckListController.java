package person.special.checklistgo.backend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import person.special.checklistgo.backend.dto.ChecklistRequest;
import person.special.checklistgo.backend.dto.ChecklistResponse;
import person.special.checklistgo.backend.dto.LineItemRequest;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.entities.LineItem;
import person.special.checklistgo.backend.services.ChecklistService;
import person.special.checklistgo.backend.services.LineItemService;

import java.lang.reflect.Type;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/checklist")
public class CheckListController {

    public static final Type LIST_TYPE = new TypeToken<Map<Long, ChecklistResponse>>() {
    }.getType();
    private ModelMapper modelMapper;

    private ChecklistService checklistService;

    private LineItemService lineItemService;

    @GetMapping
    public Map<Long, ChecklistResponse> getChecklists() {
        var checklistEntities = checklistService.getChecklists();
        Map<Long, ChecklistResponse> clResponseMap = modelMapper.map(checklistEntities, LIST_TYPE);

        return clResponseMap;
    }

    @GetMapping("/{id}")
    public ChecklistResponse getCheckList(@PathVariable Long id) {
        return modelMapper.map(checklistService.getChecklist(id), ChecklistResponse.class);
    }

    @PutMapping
    public ChecklistResponse addChecklist(@RequestBody ChecklistRequest body) {
       var cl = checklistService.addCheckList(modelMapper.map(body, Checklist.class));
       return modelMapper.map(cl, ChecklistResponse.class);
    }

    @PutMapping("/{id}")
    public ChecklistResponse editChecklist(@RequestBody ChecklistRequest body, @PathVariable Long id) {
        // ModelMapper converts entity to response and vice versa. Variables: (from) Entity, (to) dto
        var cl = modelMapper.map(body, Checklist.class);
        var clEdited = checklistService.editChecklist(id, cl);
        var response = modelMapper.map(clEdited, ChecklistResponse.class);

        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteCheckList(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
    }


    @PostMapping("/{id}")
    public ChecklistResponse addItemToChecklist(@RequestBody LineItemRequest body, @PathVariable Long id) {
        var li = modelMapper.map(body, LineItem.class);
        var cl = checklistService.getChecklist(id);
        lineItemService.addLineItem(li, cl); // when CheckList is added to LineItem, Hibernate manages the reverse relationship
        return modelMapper.map(checklistService.getChecklist(cl.getId()), ChecklistResponse.class);
    }
}