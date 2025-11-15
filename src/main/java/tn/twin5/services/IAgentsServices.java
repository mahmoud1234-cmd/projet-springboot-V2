package tn.twin5.services;

import tn.twin5.entities.Agents;
import java.util.List;

public interface IAgentsServices {
    Agents addAgents(Agents Agents);
    Agents updateAgents(Agents Agents);
    void deleteAgents(Agents Agents);
    Agents findById(Long id);
    List<Agents> findAll();
    
}
