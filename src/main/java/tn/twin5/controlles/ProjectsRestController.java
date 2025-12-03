package tn.twin5.controlles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.Projects;
import tn.twin5.services.IProjectsServices;

import java.util.List;

@RestController
@RequestMapping("projects")
@CrossOrigin(origins = "*")
public class ProjectsRestController {
    private final IProjectsServices projectsServices;

    public ProjectsRestController(IProjectsServices projectsServices) {
        this.projectsServices = projectsServices;
    }

    @PostMapping("add")
    public ResponseEntity<Projects> addProject(@RequestBody Projects project) {
        return ResponseEntity.ok(projectsServices.addProject(project));
    }

    @GetMapping("getproject")
    public ResponseEntity<List<Projects>> getProjects() {
        return ResponseEntity.ok(projectsServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectsServices.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projects> updateProject(@PathVariable Long id, @RequestBody Projects project) {
        return ResponseEntity.ok(projectsServices.updateProject(project));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Projects> deleteProject(@PathVariable Long id) {
        projectsServices.deleteProject(projectsServices.findById(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("assignToProject/{agentId}")
    public Projects assignToProject(@PathVariable Long agentId, @RequestBody Projects project) {
        return projectsServices.assignAgentToProject(project, agentId);


    }

    @GetMapping("/Expiredprojet")
    public ResponseEntity<List<Projects>> getExpiredProjects() {
        return ResponseEntity.ok(projectsServices.getExpiredProjects());
    }






}
