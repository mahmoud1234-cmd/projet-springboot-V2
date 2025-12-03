// ICallsRepository.java
package tn.twin5.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.twin5.entities.Calls;
import tn.twin5.entities.enums.Skills;

import java.util.List;

public interface ICallsRepository extends CrudRepository<Calls, Long> {

    @Query("""
            SELECT c
            FROM Calls c
            JOIN c.assignedAgent a
            WHERE a.agentsId = :idAgent
            """)
    List<Calls> findCallsByAgent(@Param("idAgent") Long idAgent);               // Q1

    @Query("""
            SELECT DISTINCT c
            FROM Calls c
            WHERE :skill MEMBER OF c.requiredSkills
            """)
    List<Calls> findCallsBySkill(@Param("skill") Skills skill);                 // Q2

    @Query("""
            SELECT c.status, COUNT(c)
            FROM Calls c
            GROUP BY c.status
            """)
    List<Object[]> countCallsByStatus();                                        // Q5

    @Query("""
            SELECT c
            FROM Calls c
            WHERE FUNCTION('DATE', c.callTime) = CURRENT_DATE
            """)
    List<Calls> findTodayCalls();                                               // Q7
}