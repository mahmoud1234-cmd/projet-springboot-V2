package tn.twin5.services;

import tn.twin5.entities.Agents;
import tn.twin5.entities.Projects;

import java.time.LocalDate;
import java.util.List;

public interface IProjectsServices {
    Projects addProject(Projects project);
    Projects updateProject(Projects project);
    void deleteProject(Projects project);
    Projects findById(Long id);
    List<Projects> findAll();
    List<Projects> getExpiredProjects();
    List<Projects> getProjectsByCriteria(LocalDate start, LocalDate end);
    Projects assignAgentToProject(Projects project, Long id);

}
