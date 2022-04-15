package person.special.checklistgo.backend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.special.checklistgo.backend.dto.ChecklistResponse;
import person.special.checklistgo.backend.entities.Checklist;
import person.special.checklistgo.backend.services.ChecklistService;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/checklist")
public class CheckListController {

    public static final Type LIST_TYPE = new TypeToken<Map<Long, ChecklistResponse>>() {
    }.getType();
    private ModelMapper modelMapper;

    private ChecklistService checklistService;

    @GetMapping
    public Map<Long, ChecklistResponse> getChecklists() {
        var checklistEntities = checklistService.getChecklists();
        modelMapper.createTypeMap(Checklist.class, ChecklistResponse.class);
        Map<Long, ChecklistResponse> clResponseMap = modelMapper.map(checklistEntities, LIST_TYPE);

        return clResponseMap;
    }
}

/*
    getChecklists() can also be written like this:
    var x = checklistEntities.entrySet().stream().map(entry -> {
        var checkListResponse = modelMapper.map(entry.getValue(), ChecklistResponse.class);
        return new AbstractMap.SimpleEntry<>(entry.getKey(), checkListResponse);
    }).collect(Collectors.toMap(k ->k.getKey(), v -> v.getValue()));
 */
