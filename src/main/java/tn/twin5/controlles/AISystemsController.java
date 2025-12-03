package tn.twin5.controlles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.AISystems;
import tn.twin5.services.AISystemsServices;

import java.util.List;
@RestController
@RequestMapping("aiSystems")
@CrossOrigin(origins = "*")

public class AISystemsController {
    private final AISystemsServices aiSystemsServices;

    public AISystemsController(AISystemsServices aiSystemsServices) {
        this.aiSystemsServices = aiSystemsServices;
    }

    @PostMapping("add")
    public ResponseEntity<AISystems> addAISystems(@RequestBody AISystems aiSystems) {
        return ResponseEntity.ok(aiSystemsServices.addAISystems(aiSystems));
    }

    @GetMapping("getaisystem")
    public ResponseEntity<List<AISystems>> getAllAISystems() {
        return ResponseEntity.ok(aiSystemsServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AISystems> getAISystemsById(@PathVariable Long id) {
        return ResponseEntity.ok(aiSystemsServices.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AISystems> updateAISystems(@PathVariable Long id, @RequestBody AISystems aiSystems) {
        return ResponseEntity.ok(aiSystemsServices.updateAISystems(aiSystems));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AISystems> deleteAISystems(@PathVariable Long id) {
        aiSystemsServices.deleteAISystems(aiSystemsServices.findById(id));
        return ResponseEntity.noContent().build();
    }
}
