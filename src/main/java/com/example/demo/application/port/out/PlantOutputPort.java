package com.example.demo.application.port.out;

import com.example.demo.application.domain.entity.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantOutputPort {

    List<Plant> findAll();

    Optional<Plant> findById(Long id);

    Plant save(Plant honey);
    void deleteById(Long id);

    Optional<Plant> findByNameAndType(String name, String type);

}

