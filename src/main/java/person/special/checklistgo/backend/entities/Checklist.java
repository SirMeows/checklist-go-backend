package person.special.checklistgo.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import person.special.checklistgo.backend.dto.ChecklistRequest;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "checklist", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @MapKey(name = "id")
    private Map<Long, ListItem> listItems = new HashMap<>();

    public Checklist(ChecklistRequest body) {
        this.name = body.getName();
    }
}
