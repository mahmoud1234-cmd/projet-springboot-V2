package tn.twin5.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.twin5.entities.Projects;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IProjectdRepository extends CrudRepository<Projects, Long> {

    @Query("""
            SELECT p
            FROM Projects p
            WHERE p.endDate > :endDate
            """)
    List<Projects> findByEndDateAfter(@Param("endDate") Date endDate);

    @Query("""
            SELECT p
            FROM Projects p
            WHERE p.startDate <= :endPeriod
              AND p.endDate   >= :startPeriod
            """)
    List<Projects> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(
            @Param("endPeriod") LocalDate endPeriod,
            @Param("startPeriod") LocalDate startPeriod
    );
}







