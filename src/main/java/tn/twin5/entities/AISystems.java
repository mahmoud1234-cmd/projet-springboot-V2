package tn.twin5.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.twin5.entities.enums.Skills;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class AISystems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aiSystemId;
    private String type;
    private Boolean available;
    @ElementCollection(targetClass = Skills.class)
    @Enumerated(EnumType.STRING)
    private Set<Skills> Skills;

    @OneToMany(mappedBy = "assignedAISystems")
    private List<Calls> aiCalls;

}
