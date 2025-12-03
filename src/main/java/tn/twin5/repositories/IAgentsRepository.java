package tn.twin5.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.twin5.entities.Agents;
import tn.twin5.entities.enums.Skills;

import java.util.List;

public interface IAgentsRepository extends CrudRepository<Agents, Long> {

    @Query("SELECT a FROM Agents a WHERE a.available = true")
    List<Agents> findByAvailableTrue();

    @Query("""
            SELECT DISTINCT a
            FROM Agents a
            JOIN a.skills s
            WHERE a.available = true
              AND s IN :skills
            """)
    List<Agents> findByAvailableTrueAndSkillsIn(@Param("skills") List<Skills> skills);

    @Query("""
            SELECT DISTINCT a
            FROM Agents a
            WHERE :skill MEMBER OF a.skills
            """)
    List<Agents> findAgentsBySkill(@Param("skill") Skills skill);                       // Q3

    @Query("""
            SELECT a
            FROM Agents a
            WHERE a.available = true
            ORDER BY (
                SELECT COUNT(rs)
                FROM Calls c
                JOIN c.requiredSkills rs
                WHERE c.callsId = :callsId
                  AND rs MEMBER OF a.skills
            ) DESC,
            SIZE(a.skills) DESC
            """)
    Agents findMostCompetentAgentForCall(@Param("callsId") Long callsId);               // Q4

    @Query("""
            SELECT a.name, COUNT(c)
            FROM Calls c
            JOIN c.assignedAgent a
            GROUP BY a.name
            HAVING COUNT(c) > 5
            """)
    List<Object[]> findTopActiveAgents();                                               // Q6

    List<Agents> findAgentsBySkillsContains(Skills skill);
}
