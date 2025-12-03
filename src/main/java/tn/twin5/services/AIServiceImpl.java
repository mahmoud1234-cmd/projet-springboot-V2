package tn.twin5.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.twin5.entities.AISystems;
import tn.twin5.repositories.IASystemsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service

@Slf4j

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

    @Scheduled(cron = "*/10 * * * * *")
    public void cleanOldAISystems() {

        log.info(" INFO: Cleaning old AI systems");

        log.debug(" DEBUG : ");

        List<AISystems> all = (List<AISystems>) iaSystemsRepository.findAll();

        if (all.isEmpty()) {
            log.warn(" WARNING: ");
        }

        log.info(" INFO :{}", all.size());

        try {
            int x = 10 / 0;
        } catch (Exception e) {
            log.error("ERROR : {}", e.getMessage());
        }

        log.info(" INFO :  {}", LocalDateTime.now());
    }


}


