package tn.twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.twin5.entities.Agents;
import tn.twin5.entities.Calls;
import tn.twin5.entities.enums.CallStatus;
import tn.twin5.repositories.IAgentsRepository;
import tn.twin5.repositories.ICallsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CallsServiceImpl implements ICallsServices{

    private final ICallsRepository callsRepository;
    private final IAgentsRepository agentsRepository;



    @Override
    public Calls addCalls(Calls calls) {
        calls.setStatus(CallStatus.ON_HOLD);
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

    @Override
    public Calls assignToAgent(Long callsId, Long agentId) {
        Calls calls = findById(callsId);
        Agents agent = agentsRepository.findById(agentId).orElse(null);
        calls.setAssignedAgent(agent);//affectation
        return callsRepository.save(calls);
    }

    @Override
    public Calls assignToAgent(Calls calls, Long agentId) {
        Agents agent = agentsRepository.findById(agentId).orElse(null);
        calls.setAssignedAgent(agent);
        return callsRepository.save(calls);
    }
}
