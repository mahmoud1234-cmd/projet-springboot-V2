package tn.twin5.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.twin5.entities.enums.Skills;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentsId;

    private String name;

    @ElementCollection(targetClass = Skills.class)
    @Enumerated(EnumType.STRING)
    private Set<Skills> skills;

    private Boolean available;

    @ManyToMany(mappedBy = "agents")
    private Set<Projects> myProjects;

    @OneToMany(mappedBy = "assignedAgent")
    private List<Calls> agentCalls;
}
