// CallsServiceImpl.java
package tn.twin5.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.twin5.entities.*;
import tn.twin5.entities.enums.CallStatus;
import tn.twin5.entities.enums.Skills;
import tn.twin5.repositories.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CallsServiceImpl implements ICallsServices {

    private final ICallsRepository callsRepository;
    private final IAgentsRepository agentsRepository;
    private final IASystemsRepository aiSystemsRepository;

    // ──────────────────────────────────────────────────────────────
    // Méthodes de base
    // ──────────────────────────────────────────────────────────────

    @Override
    public Calls addCalls(Calls calls) {
        calls.setStatus(CallStatus.ON_HOLD);
        calls.setCallTime(LocalDateTime.now());
        return callsRepository.save(calls);
    }

    @Override
    public Calls updateCalls(Calls calls) {
        return callsRepository.save(calls);
    }

    @Override
    public void deleteCalls(Calls calls) {
        callsRepository.delete(calls);
    }

    @Override
    public Calls findById(Long id) {
        return callsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Calls> findAll() {
        return (List<Calls>) callsRepository.findAll();
    }

    // ──────────────────────────────────────────────────────────────
    // Q.1 → assignCallToAgent (avec toutes les règles)
    // ──────────────────────────────────────────────────────────────
    @Override
    @Transactional
    public void assignCallToAgent(Long callId, Long agentId) {
        Calls call = callsRepository.findById(callId)
                .orElseThrow(() -> new RuntimeException("Appel non trouvé : " + callId));

        Agents agent = agentsRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent non trouvé : " + agentId));


        if (Boolean.FALSE.equals(agent.getAvailable())) {
            throw new RuntimeException("L'agent n'est pas disponible");
        }

         call.setStatus(CallStatus.IN_PROGRESS);
        call.setAssignedAgent(agent);
        call.setAssignedAISystems(null);

         agent.setAvailable(false);

        callsRepository.save(call);
        agentsRepository.save(agent);
    }

   @Override
    @Transactional
    public void assignCallToAISystem(Long callId, Long aiSystemId) {
        Calls call = callsRepository.findById(callId)
                .orElseThrow(() -> new RuntimeException("Appel non trouvé"));

        AISystems ai = aiSystemsRepository.findById(aiSystemId)
                .orElseThrow(() -> new RuntimeException("Système IA non trouvé"));


        if (Boolean.FALSE.equals(ai.getAvailable())) {
            throw new RuntimeException("Le système IA n'est pas disponible");
        }

         if (ai.getCurrentCallCount() == null) ai.setCurrentCallCount(0);
        if (ai.getCurrentCallCount() >= (ai.getMaxConcurrentCalls() != null ? ai.getMaxConcurrentCalls() : 2)) {
            throw new RuntimeException("Le système IA gère déjà le maximum d'appels (2)");
        }

        call.setStatus(CallStatus.IN_PROGRESS);
        call.setAssignedAISystems(ai);
        call.setAssignedAgent(null);

         ai.setCurrentCallCount(ai.getCurrentCallCount() + 1);

         if (ai.getCurrentCallCount() >= 2) {
            ai.setAvailable(false);
        }

        callsRepository.save(call);
        aiSystemsRepository.save(ai);
    }


    @Override
    public boolean callRequiresHumanAgent(Calls call) {
        if (call == null || call.getRequiredSkills() == null) {
            return false;
        }
        return call.getRequiredSkills().contains(Skills.TECHNICAL_SUPPORT);
    }

    @Override
    @Transactional
    public void assignCallsToAgents(Set<Long> callIds) {
        for (Long callId : callIds) {
            Calls call = callsRepository.findById(callId).orElse(null);
            if (call == null || call.getStatus() != CallStatus.ON_HOLD) {
                continue;
            }


            if (callRequiresHumanAgent(call)) {

                Agents suitableAgent = agentsRepository.findByAvailableTrue().stream()
                        .filter(agent -> agent.getSkills() != null &&
                                agent.getSkills().stream()
                                        .anyMatch(skill -> call.getRequiredSkills().contains(skill)))
                        .findFirst()
                        .orElse(null);

                if (suitableAgent != null) {
                    call.setStatus(CallStatus.IN_PROGRESS);
                    call.setAssignedAgent(suitableAgent);
                    suitableAgent.setAvailable(false);

                    callsRepository.save(call);
                    agentsRepository.save(suitableAgent);
                }
             }
         }
    }


    @Override
    public Calls assignToAgent(Long callsId, Long agentId) {
        assignCallToAgent(callsId, agentId);
        return findById(callsId);
    }

    @Override
    public Calls assignToAgent(Calls calls, Long agentId) {
        Agents agent = agentsRepository.findById(agentId).orElse(null);
        if (agent != null && Boolean.TRUE.equals(agent.getAvailable())) {
            calls.setAssignedAgent(agent);
            agent.setAvailable(false);
            agentsRepository.save(agent);
        }
        return callsRepository.save(calls);
    }
}