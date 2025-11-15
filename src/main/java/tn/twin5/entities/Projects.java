package tn.twin5.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String libelle;
    LocalDate startDate;
    LocalDate endDate;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    ProjectDetails detail;

    @ManyToMany
    Set<Agents> agents = new HashSet<>();


}
