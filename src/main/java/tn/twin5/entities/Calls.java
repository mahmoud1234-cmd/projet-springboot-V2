// Calls.java (corrigé et complété)
package tn.twin5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.twin5.entities.enums.CallStatus;
import tn.twin5.entities.enums.Skills;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Calls implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long callsId;

    LocalDateTime callTime;

    String callerNumber;

    @ElementCollection(targetClass = Skills.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "call_required_skills")
    Set<Skills> requiredSkills;

    @Enumerated(EnumType.STRING)
    CallStatus status = CallStatus.ON_HOLD;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    AISystems assignedAISystems;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    Agents assignedAgent;
}