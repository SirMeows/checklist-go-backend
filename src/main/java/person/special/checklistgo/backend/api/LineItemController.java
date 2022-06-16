package person.special.checklistgo.backend.api;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;
import person.special.checklistgo.backend.dto.LineItemRequest;
import person.special.checklistgo.backend.dto.LineItemResponse;
import person.special.checklistgo.backend.entities.LineItem;
import person.special.checklistgo.backend.services.LineItemService;

import java.lang.reflect.Type;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class LineItemController {

    public static final Type LIST_TYPE = new TypeToken<Map<Long, LineItemResponse>>() {
    }.getType();

    private ModelMapper modelMapper;

    private LineItemService lineItemService;

    @GetMapping
    public Map<Long, LineItemResponse> getLineItems() {
        var liEntities = lineItemService.getLineItems();
        modelMapper.createTypeMap(LineItem.class, LineItemResponse.class);
        Map<Long, LineItemResponse> liResponseMap = modelMapper.map(liEntities, LIST_TYPE);

        return liResponseMap;
    }

    @GetMapping("/{id}")
    public LineItemResponse getLineItem(@PathVariable Long id) {
        return modelMapper.map(lineItemService.getLineItem(id), LineItemResponse.class);
    }

    @PutMapping("/{id}")
    public LineItemResponse editLineItem(@RequestBody LineItemRequest body, @PathVariable Long id) {
        var li = modelMapper.map(body, LineItem.class);
        var liEdited = lineItemService.editLineItem(id, li);
        var response = modelMapper.map(liEdited, LineItemResponse.class);
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteLineItem(@PathVariable Long id) {
        lineItemService.deleteLineItem(id);
    }
}
