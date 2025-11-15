package tn.twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.twin5.entities.ProjectDetails;
import tn.twin5.repositories.IProjectDetailsRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectDetailsServiceImpl implements IProjectDetailsServices{

    private IProjectDetailsRepository detailsRepository;

    @Autowired
    public ProjectDetailsServiceImpl(IProjectDetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    @Override
    public ProjectDetails addProjectDetails(ProjectDetails details) {
        return detailsRepository.save(details);
    }

    @Override
    public ProjectDetails updateProjectDetails(ProjectDetails details) {
        return detailsRepository.save(details);
    }

    @Override
    public void deleteProjectDetails(ProjectDetails details) {
        detailsRepository.delete(details);
    }

    @Override
    public ProjectDetails findById(Long id) {
        return detailsRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProjectDetails> findAll() {
        return (List<ProjectDetails>) detailsRepository.findAll();
    }
}
