package tn.twin5.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.twin5.entities.ProjectDetails;

public interface IProjectDetailsRepository extends CrudRepository<ProjectDetails, Long> {
}
