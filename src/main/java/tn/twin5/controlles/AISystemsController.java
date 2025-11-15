package tn.twin5.controlles;

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
    public  AISystems addAISystems(@RequestBody AISystems aiSystems) {
        return  aiSystemsServices.addAISystems(aiSystems);
    }

    @GetMapping("getaisystem")
    public  List<AISystems>  getAllAISystems() {
        return  aiSystemsServices.findAll();
    }

    @GetMapping("/{id}")
    public  AISystems  getAISystemsById(@PathVariable Long id) {
        return  aiSystemsServices.findById(id);
    }

    @PutMapping("/{id}")
    public  AISystems updateAISystems(@PathVariable Long id, @RequestBody AISystems aiSystems)
    {
        return  aiSystemsServices.updateAISystems(aiSystems);
    }

    @DeleteMapping("delete")
    public void deleteAISystems(@RequestBody AISystems aiSystems) {
        aiSystemsServices.deleteAISystems(aiSystems);
    }


}
