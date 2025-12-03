package tn.twin5.services;

import org.aspectj.weaver.loadtime.Agent;
import tn.twin5.entities.Agents;
import tn.twin5.entities.enums.Skills;

import java.util.List;

public interface IAgentsServices {
    Agents addAgents(Agents Agents);
    Agents updateAgents(Agents Agents);
    void deleteAgents(Agents Agents);
    Agents findById(Long id);
    List<Agents> findAll();
    List<Agents> getAvailableAgentsWithSkills(List<Skills> skills);


    List<Agents> findAgentsBySkills (Skills skill);

}
