package com.example.demo.application.port.in;

import com.example.demo.application.domain.entity.Plant;

import java.util.List;

public interface PlantInputPort {
    Plant getPlantById(Long id);
    List<Plant> getAllPlants();
    Plant savePlant(Plant plantDTO);
    void deletePlant(Long id);
}

