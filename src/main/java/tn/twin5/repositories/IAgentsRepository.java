package tn.twin5.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.twin5.entities.Agents;

public interface IAgentsRepository extends CrudRepository<Agents, Long> {
}
