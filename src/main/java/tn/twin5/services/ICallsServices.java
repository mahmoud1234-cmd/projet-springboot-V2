package tn.twin5.services;

import tn.twin5.entities.Agents;
import tn.twin5.entities.Calls;

import java.util.List;

public interface ICallsServices {
    Calls addCalls(Calls calls);
    Calls updateCalls(Calls calls);
    void deleteCalls(Calls calls);
    Calls findById(Long id);
    List<Calls> findAll();

    Calls assignToAgent(Long callsId, Long agentId);
    Calls assignToAgent(Calls calls, Long agentId);
}
