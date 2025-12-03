package tn.twin5.services;

import tn.twin5.entities.AISystems;

import java.util.List;

public interface AISystemsServices {
    AISystems addAISystems(AISystems aiSystems);
    AISystems updateAISystems(AISystems aiSystems);
    void deleteAISystems(AISystems aiSystems);
    AISystems findById(Long id);
    List<AISystems> findAll();


}
