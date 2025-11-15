package tn.twin5.controlles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.ProjectDetails;
import tn.twin5.services.IProjectDetailsServices;

import java.util.List;

@RestController
@RequestMapping("projectdetails")
@CrossOrigin("*")
public class ProjectDetailsRestController {
    private final IProjectDetailsServices projectDetailsServices;

    public ProjectDetailsRestController(IProjectDetailsServices projectDetailsServices) {
        this.projectDetailsServices = projectDetailsServices;
    }

    @PostMapping("add")
    public ProjectDetails addProjectDetails(@RequestBody ProjectDetails details) {
        return projectDetailsServices.addProjectDetails(details);
    }

    @GetMapping("getdetails")
    public List<ProjectDetails> getProjectDetails() {
        return projectDetailsServices.findAll();
    }

    @GetMapping("getdetail/{id}")
    public ProjectDetails getProjectDetailsById(@PathVariable Long id) {
        return projectDetailsServices.findById(id);
    }

    @PutMapping("update")
    public ProjectDetails updateProjectDetails(@RequestBody ProjectDetails details) {
        return projectDetailsServices.updateProjectDetails(details);
    }

    @DeleteMapping("delete")
    public void deleteProjectDetails(@RequestBody ProjectDetails details) {
        projectDetailsServices.deleteProjectDetails(details);
    }
}
