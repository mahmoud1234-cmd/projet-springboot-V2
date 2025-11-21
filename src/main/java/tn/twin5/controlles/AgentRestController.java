package tn.twin5.controlles;

import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.Agents;
import tn.twin5.entities.enums.Skills;
import tn.twin5.services.IAgentsServices;

import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("agents")
@CrossOrigin(origins = "*")
public class AgentRestController {
    private final IAgentsServices agentsServices;

    public AgentRestController(IAgentsServices agentsServices) {
        this.agentsServices = agentsServices;
    }

    @PostMapping("add")
    public Agents addAgent(@RequestBody Agents agent) {
        return agentsServices.addAgents(agent);
    }

    @GetMapping("getagent")
    public List<Agents> getAgents() {
        return agentsServices.findAll();
    }

    @GetMapping("/{id}")
    public Agents getAgentById(@PathVariable Long id) {
        return agentsServices.findById(id);
    }

    @PutMapping("update")
    public Agents updateAgent(@RequestBody Agents agent) {
        return agentsServices.updateAgents(agent);
    }

    @DeleteMapping("delete")
    public void deleteAgent(@RequestBody Agents agent) {
        agentsServices.deleteAgents(agent);
    }

    @GetMapping("available")
    public List<Agents> getAvailableAgents() {
        return agentsServices.findAvailableAgents();
    }

    @GetMapping("by-skill/{skill}")
    public List<Agents> getAgentsBySkill(@PathVariable Skills skill) {
        return agentsServices.findAgentsBySkill(skill);
    }

    @PostMapping("available-with-skills")
    public List<Agents> getAvailableAgentsWithSkills(@RequestBody Set<Skills> requiredSkills) {
        return agentsServices.findAvailableAgentsWithSkills(requiredSkills);
    }
}
