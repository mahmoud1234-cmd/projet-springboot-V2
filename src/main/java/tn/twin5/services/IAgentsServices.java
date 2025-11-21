package tn.twin5.services;

import tn.twin5.entities.Agents;
import java.util.List;
import java.util.Set;

public interface IAgentsServices {
    Agents addAgents(Agents Agents);
    Agents updateAgents(Agents Agents);
    void deleteAgents(Agents Agents);
    Agents findById(Long id);
    List<Agents> findAll();

    // Méthodes de recherche
    List<Agents> findAvailableAgents();
    List<Agents> findAgentsBySkill(tn.twin5.entities.enums.Skills skill);
    List<Agents> findAvailableAgentsWithSkills(Set<tn.twin5.entities.enums.Skills> requiredSkills);
}
