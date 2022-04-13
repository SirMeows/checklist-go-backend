package person.special.checlistgobackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import person.special.checlistgobackend.dto.ChecklistRequest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Set<ListItem> listItems = new HashSet<>();

    public Checklist(ChecklistRequest body) {
        this.name = body.getName();
    }
}
