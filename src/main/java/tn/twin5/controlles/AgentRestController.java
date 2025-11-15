package tn.twin5.controlles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.Agents;
import tn.twin5.services.IAgentsServices;

import java.util.List;
@RestController
@RequestMapping("agents")
@CrossOrigin(origins = "*")
public class AgentRestController {
    private final IAgentsServices agentsServices;

    public AgentRestController(IAgentsServices agentsServices) {
        this.agentsServices = agentsServices;
    }

    @PostMapping("add")
    public ResponseEntity<Agents> addAgent(@RequestBody Agents agent) {
        return ResponseEntity.ok(agentsServices.addAgents(agent));
    }

    @GetMapping("getagent")
    public ResponseEntity<List<Agents>> getAgents() {
        return ResponseEntity.ok(agentsServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agents> getAgentById(@PathVariable Long id) {
        return ResponseEntity.ok(agentsServices.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agents> updateAgent(@PathVariable Long id, @RequestBody Agents agent) {
        return ResponseEntity.ok(agentsServices.updateAgents(agent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Agents> deleteAgent(@PathVariable Long id) {
        agentsServices.deleteAgents(agentsServices.findById(id));
        return ResponseEntity.noContent().build();
    }
}
