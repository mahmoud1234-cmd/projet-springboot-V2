package tn.twin5.services;

import tn.twin5.entities.Agents;
import tn.twin5.entities.Projects;

import java.util.List;

public interface IProjectsServices {
    Projects addProject(Projects project);
    Projects updateProject(Projects project);
    void deleteProject(Projects project);
    Projects findById(Long id);
    List<Projects> findAll();

    Projects assignAgentToProject(Projects project, Long id);


    List<Projects> getExpiredProjects();
}
