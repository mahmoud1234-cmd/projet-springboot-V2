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
//@Table(name = "t_calls")
public class Calls implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long callsId;
     LocalDateTime callTime;
    // @Column(nullable = false)
     String callerNumber;

    @ElementCollection(targetClass = Skills.class)
    @Enumerated(EnumType.STRING)
     Set<Skills> requiredSkills;
    @Enumerated(EnumType.STRING)
    CallStatus status;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private AISystems assignedAISystems;

    @ManyToOne(cascade =CascadeType.PERSIST)
    //@JsonIgnore
    @ToString.Exclude
    private Agents assignedAgent;

}
