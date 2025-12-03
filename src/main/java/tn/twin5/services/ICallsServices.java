// ICallsServices.java
package tn.twin5.services;

import tn.twin5.entities.Calls;
import java.util.List;
import java.util.Set;

public interface ICallsServices {
    Calls addCalls(Calls calls);
    Calls updateCalls(Calls calls);
    void deleteCalls(Calls calls);
    Calls findById(Long id);
    List<Calls> findAll();

    // Q.1
    void assignCallToAgent(Long callId, Long agentId);

    // Q.2
    void assignCallToAISystem(Long callId, Long aiSystemId);

    // Q.3
    boolean callRequiresHumanAgent(Calls call);

    // Q.5 (la plus complète demandée)
    void assignCallsToAgents(Set<Long> callIds);

    // Anciennes méthodes (conservées pour compatibilité)
    Calls assignToAgent(Long callsId, Long agentId);
    Calls assignToAgent(Calls calls, Long agentId);
}