package tn.twin5.services;

import tn.twin5.entities.ProjectDetails;

import java.util.List;
public interface IProjectDetailsServices {
    ProjectDetails addProjectDetails(ProjectDetails details);
    ProjectDetails updateProjectDetails(ProjectDetails details);
    void deleteProjectDetails(ProjectDetails details);
    ProjectDetails findById(Long id);
    List<ProjectDetails> findAll();
}
