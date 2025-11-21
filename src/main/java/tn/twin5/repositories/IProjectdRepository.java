package tn.twin5.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.twin5.entities.Projects;

import java.time.LocalDate;
import java.util.List;



    public interface IProjectdRepository extends CrudRepository<Projects, Long> {
        List<Projects> findByEndDateBefore(LocalDate date);

        List<Projects> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate start, LocalDate end);
    }
