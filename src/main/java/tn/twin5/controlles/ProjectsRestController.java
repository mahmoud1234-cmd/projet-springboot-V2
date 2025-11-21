package tn.twin5.controlles;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.Projects;
import tn.twin5.services.IProjectsServices;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("projects")
@CrossOrigin(origins = "*")
public class ProjectsRestController {
    private final IProjectsServices projectsServices;


    @PostMapping("add")
    public Projects  addProject(@RequestBody Projects project) {
        return projectsServices.addProject(project);
    }

    @GetMapping("getproject")
    public List<Projects> getProjects() {
        return projectsServices.findAll();
    }

    @GetMapping("/{id}")
    public  Projects  getProjectById(@PathVariable Long id) {
        return projectsServices.findById(id);
    }

    @PutMapping("/{id}")
    public  Projects  updateProject(@PathVariable Long id, @RequestBody Projects project) {
        return  projectsServices.updateProject(project);
    }

    @DeleteMapping("delete ")
    public void deleteProject(@RequestBody Projects project) {
        projectsServices.deleteProject(project);}

    @PostMapping("assignToProject/{agentId}")
    public Projects assignToProject(@PathVariable Long agentId, @RequestBody Projects project) {
        return projectsServices.assignAgentToProject(project, agentId);}

        @GetMapping("/ExpiredProjects")
        public List<Projects> getExpiredProjects() {
            return projectsServices.getExpiredProjects();
        }

        @GetMapping("/getProjectByCriteria")
        public List<Projects> getProjectByCriteria (LocalDate start, LocalDate end) {
            return projectsServices.getProjectsByCriteria(start,end);
        }
    }

