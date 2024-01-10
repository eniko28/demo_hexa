package com.example.demo.application.port.out;

import com.example.demo.application.domain.entity.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantOutputPort {
    List<Plant> getAllPlants();
    Optional<Plant> findByNameAndType(String name, String type);
    Plant savePlant(Plant plant);
    void deletePlant(Long id);
}

