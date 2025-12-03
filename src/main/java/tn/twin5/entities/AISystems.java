// AISystems.java (corrigé : ajout du compteur + available par défaut)
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
    Long aiSystemId;

    String type;

    Boolean available = true;  // important : Boolean → true par défaut

    Integer currentCallCount = 0;  // AJOUT OBLIGATOIRE pour Q.2

    Integer maxConcurrentCalls = 2; // AJOUT OBLIGATOIRE

    @ElementCollection(targetClass = Skills.class)
    @Enumerated(EnumType.STRING)
    Set<Skills> Skills;

    @OneToMany(mappedBy = "assignedAISystems")
    List<Calls> aiCalls;
}