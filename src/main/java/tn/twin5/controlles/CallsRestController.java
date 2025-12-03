package tn.twin5.controlles;

import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.Calls;
import tn.twin5.services.ICallsServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("calls")
@CrossOrigin(origins = "*")
@Tag(name = "Calls API", description = "Gestion des appels et affectations aux agents")
public class CallsRestController {

    private final ICallsServices callService;

    public CallsRestController(ICallsServices callService) {
        this.callService = callService;
    }

    // -------------------- ADD --------------------
    @PostMapping("add")
    @Operation(summary = "Ajouter un appel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Appel ajouté avec succès"),
            @ApiResponse(responseCode = "400", description = "Erreur dans les données")
    })
    public Calls addCall(@RequestBody Calls call) {
        return callService.addCalls(call);
    }

    // -------------------- GET ALL --------------------
    @GetMapping("getcalls")
    @Operation(summary = "Récupérer la liste de tous les appels")
    public List<Calls> getAllCalls() {
        return callService.findAll();
    }

    // -------------------- GET BY ID --------------------
    @GetMapping("get/{id}")
    @Operation(summary = "Récupérer un appel par son ID")
    public Calls getCallById(@PathVariable Long id) {
        return callService.findById(id);
    }

    // -------------------- UPDATE --------------------
    @PutMapping("update")
    @Operation(summary = "Mettre à jour un appel")
    public Calls updateCall(@RequestBody Calls call) {
        return callService.updateCalls(call);
    }

    // -------------------- DELETE --------------------
    @DeleteMapping("delete")
    @Operation(summary = "Supprimer un appel")
    public void deleteCall(@RequestBody Calls call) {
        callService.deleteCalls(call);
    }

    // -------------------- ASSIGN 1 --------------------
    @PutMapping("assignToAgent/{callsId}/{agentId}")
    @Operation(summary = "Assigner un appel existant à un agent en utilisant leurs IDs")
    public Calls assignToAgent(
            @PathVariable Long callsId,
            @PathVariable Long agentId
    ) {
        return callService.assignToAgent(callsId, agentId);
    }

    // -------------------- ASSIGN 2 --------------------
    @PostMapping("assignToAgent/{agentId}")
    @Operation(summary = "Assigner un appel (objet) à un agent")
    public Calls assignToAgent(
            @RequestBody Calls calls,
            @PathVariable Long agentId
    ) {
        return callService.assignToAgent(calls, agentId);
    }

    @PutMapping("/assign/agent/{callId}/{agentId}")
    public void assignCallToAgent(@PathVariable Long callId, @PathVariable Long agentId) {
        callService.assignCallToAgent(callId, agentId);
    }

    @PutMapping("/assign/ai/{callId}/{aiId}")
    public void assignToAI(@PathVariable Long callId, @PathVariable Long aiId) {
        callService.assignCallToAISystem(callId, aiId);
    }

    @PutMapping("/auto-assign")
    public void autoAssign(@RequestBody Set<Long> callIds) {
        callService.assignCallsToAgents(callIds);
    }
}
