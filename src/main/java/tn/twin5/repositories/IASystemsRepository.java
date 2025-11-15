package tn.twin5.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.twin5.entities.AISystems;

public interface IASystemsRepository extends CrudRepository<AISystems, Long> {
}
