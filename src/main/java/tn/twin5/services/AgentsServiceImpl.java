package tn.twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tn.twin5.entities.Agents;
import java.util.List;
import java.util.Set;

import tn.twin5.entities.enums.Skills;
import tn.twin5.repositories.IAgentsRepository;

@Service
//@RequiredArgsConstructor
public class AgentsServiceImpl implements IAgentsServices {

    private IAgentsRepository agentsRepository;

    @Autowired
    public AgentsServiceImpl(IAgentsRepository agentsRepository) {
        this.agentsRepository = agentsRepository;
    }

    @Override
    public Agents addAgents(Agents Agents) {
        return agentsRepository.save(Agents);
    }

    @Override
    public Agents updateAgents(Agents Agents) {
        return agentsRepository.save(Agents);
    }

    @Override
    public void deleteAgents(Agents Agents) {
        agentsRepository.delete(Agents);
    }

    @Override
    public Agents findById(Long id) {
        return agentsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agents> findAll() {
        return (List<Agents>) agentsRepository.findAll();
    }

    @Override
    public List<Agents> findAvailableAgents() {
        return ((List<Agents>) agentsRepository.findAll())
                .stream()
                .filter(Agents::getAvailable)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<Agents> findAgentsBySkill(tn.twin5.entities.enums.Skills skill) {
        return ((List<Agents>) agentsRepository.findAll())
                .stream()
                .filter(agent -> agent.getSkills() != null && agent.getSkills().contains(skill))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<Agents> findAvailableAgentsWithSkills(Set<Skills> requiredSkills) {
        return ((List<Agents>) agentsRepository.findAll())
                .stream()
                .filter(agent -> agent.getAvailable() != null && agent.getAvailable())
                .filter(agent -> agent.getSkills() != null && agent.getSkills().containsAll(requiredSkills))
                .collect(java.util.stream.Collectors.toList());
    }
}
