package tn.twin5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.twin5.entities.enums.Skills;
import jakarta.persistence.*;


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
    private Set<Skills> Skills;
    private Boolean available;

    @ManyToMany(mappedBy = "agents")
    Set<Projects> myProjects;

    @OneToMany(mappedBy = "assignedAgent")
    private List<Calls> agentCalls;
}
