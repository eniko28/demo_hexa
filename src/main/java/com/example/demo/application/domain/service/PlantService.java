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
public class PlantService implements PlantInputPort {

    private final PlantOutputPort plantOutputPort;

    @Autowired
    protected PlantService(PlantOutputPort plantOutputPort) {
        this.plantOutputPort = plantOutputPort;
    }

    public List<Plant> getAllPlants() {
        return plantOutputPort.findAll();
    }

    public Plant getPlantById(Long id) {
        return plantOutputPort.findById(id).orElse(null);
    }

    public Plant savePlant(Plant plant) {

        Optional<Plant> existingPlant = plantOutputPort.findByNameAndType(plant.getName(), plant.getType());
        if (existingPlant.isPresent()) {
            Plant existing = existingPlant.get();
            existing.setQuantity(existing.getQuantity() + plant.getQuantity());
            return plantOutputPort.save(existing);
        } else {
            return plantOutputPort.save(plant);
        }
    }

    public void deletePlant(Long id) {
        Optional<Plant> existingPlant = plantOutputPort.findById(id);
        if (existingPlant.isPresent()) {

            Plant plant = existingPlant.get();

            int currentQuantity = plant.getQuantity();
            if (currentQuantity > 0) {
                plant.setQuantity(currentQuantity - 1);
                plantOutputPort.save(plant);
                if (currentQuantity == 1) {
                    plantOutputPort.deleteById(id);
                }
            }
        } else {
            throw new IllegalArgumentException("Nem található növény az adott azonosítóval: " + id);
        }
    }
}
