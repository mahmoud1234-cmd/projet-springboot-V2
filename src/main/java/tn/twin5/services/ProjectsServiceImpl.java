package tn.twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.twin5.entities.Agents;
import tn.twin5.entities.Projects;
import tn.twin5.repositories.IAgentsRepository;
import tn.twin5.repositories.IProjectdRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements IProjectsServices {

    private final IProjectdRepository projectdRepository;
    private final IAgentsRepository agentsRepository;



    @Override
    public Projects addProject(Projects project) {
        return projectdRepository.save(project);
    }

    @Override
    public Projects updateProject(Projects project) {
        return projectdRepository.save(project);
    }

    @Override
    public void deleteProject(Projects project) {
        projectdRepository.delete(project);
    }

    @Override
    public Projects findById(Long id) {
        return projectdRepository.findById(id).orElse(null);
    }

    @Override
    public List<Projects> findAll() {
        return (List<Projects>) projectdRepository.findAll();
    }

    @Override
    public Projects assignAgentToProject(Projects project, Long id) {
        Agents agent = agentsRepository.findById(id).orElse(null);
        project.getAgents().add(agent);
        return projectdRepository.save(project);

    }

    @Override
    public List<Projects> getExpiredProjects() {


        return projectdRepository.findByEndDateAfter(new Date()) ;
    }
}
