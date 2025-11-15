package tn.twin5.controlles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.twin5.entities.Calls;
import tn.twin5.services.ICallsServices;

import java.util.List;

@RestController
@RequestMapping("calls")
@CrossOrigin(origins = "*")
public class CallsRestController {

    private final ICallsServices callService;

    public CallsRestController(ICallsServices callService) {
        this.callService = callService;
    }

    @PostMapping("add")
    public Calls addCall(@RequestBody Calls call) {
        return callService.addCalls(call);
    }

    @GetMapping("getcalls")
    public List<Calls> getAllCalls() {
        return callService.findAll();
    }

    @GetMapping("get/{id}")
    public Calls getCallById(@PathVariable Long id) {
        return callService.findById(id);
    }

    @PutMapping("update")
    public Calls updateCall(@RequestBody Calls call) {
        return callService.updateCalls(call);
    }

    @DeleteMapping("delete")
    public void deleteCall(@RequestBody Calls call) {
        callService.deleteCalls(call);
    }

    @PutMapping("assignToAgent/{callsId}/{agentId}")

    public Calls assignToAgent(@PathVariable Long callsId, @PathVariable Long agentId){
        return callService.assignToAgent(callsId, agentId);
    }

    @PostMapping("assignToAgent/{agentId}")
    public Calls assignToAgent(@RequestBody Calls calls, @PathVariable Long agentId){
        return callService.assignToAgent(calls, agentId);
    }
}