package tn.twin5.services;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tn.twin5.entities.Agents;
import java.util.List;

import tn.twin5.entities.enums.Skills;
import tn.twin5.repositories.IAgentsRepository;

@Service
@Slf4j

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
    public List<Agents> getAvailableAgentsWithSkills(List<Skills> skills) {
        if (skills == null || skills.isEmpty()) {
            return agentsRepository.findByAvailableTrue();                    // tous les disponibles
        } else {
            return agentsRepository.findByAvailableTrueAndSkillsIn(skills);   // au moins 1 skill de la liste
        }
    }



    @Override
    public List<Agents> findAgentsBySkills(Skills skill) {
        return agentsRepository.findAgentsBySkillsContains(skill);
    }


}
