package tn.twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.twin5.entities.AISystems;
import tn.twin5.repositories.IASystemsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AISystemsServices {

    private IASystemsRepository iaSystemsRepository;

    @Autowired
    public AIServiceImpl(IASystemsRepository iaSystemsRepository) {
        this.iaSystemsRepository = iaSystemsRepository;
    }
    @Override
    public AISystems addAISystems(AISystems aiSystems) {
        return iaSystemsRepository.save(aiSystems);
    }

    @Override
    public AISystems updateAISystems(AISystems aiSystems) {
        return iaSystemsRepository .save(aiSystems);
    }

    @Override
    public void deleteAISystems(AISystems aiSystems) {
        iaSystemsRepository.delete(aiSystems);
    }

    @Override
    public AISystems findById(Long id) {
        return iaSystemsRepository.findById(id).orElse(null);
    }

    @Override
    public List<AISystems> findAll() {
        return (List<AISystems>)iaSystemsRepository.findAll();
    }
}
