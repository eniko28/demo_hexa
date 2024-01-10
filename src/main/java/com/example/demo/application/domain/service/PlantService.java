package com.example.demo.application.domain.service;

import com.example.demo.application.domain.entity.Plant;
import com.example.demo.adapter.out.persistence.PlantRepository;
import com.example.demo.application.port.in.PlantInputPort;
import com.example.demo.application.port.out.PlantOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class PlantService implements PlantOutputPort, PlantInputPort {

    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Plant getPlantById(Long id) {
        return plantRepository.findById(id).orElse(null);
    }

    public Plant savePlant(Plant plant) {

        Optional<Plant> existingPlant = plantRepository.findByNameAndType(plant.getName(), plant.getType());
        if (existingPlant.isPresent()) {
            Plant existing = existingPlant.get();
            existing.setQuantity(existing.getQuantity() + plant.getQuantity());
            return plantRepository.save(existing);
        } else {
            return plantRepository.save(plant);
        }
    }

    public void deletePlant(Long id) {
        Optional<Plant> existingPlant = plantRepository.findById(id);
        if (existingPlant.isPresent()) {

            Plant plant = existingPlant.get();

            int currentQuantity = plant.getQuantity();
            if (currentQuantity > 0) {
                plant.setQuantity(currentQuantity - 1);
                plantRepository.save(plant);
                if (currentQuantity == 1) {
                    plantRepository.deleteById(id);
                }
            }
        } else {
            throw new IllegalArgumentException("Nem található növény az adott azonosítóval: " + id);
        }
    }
}
