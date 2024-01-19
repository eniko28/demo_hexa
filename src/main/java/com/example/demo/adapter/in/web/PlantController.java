package com.example.demo.adapter.in.web;

import com.example.demo.application.domain.entity.Plant;
import com.example.demo.application.domain.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping("/{id}")
    public Plant getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @PostMapping({"/add"})
    public Plant savePlant(@RequestBody Plant plant) {
        return plantService.savePlant(plant);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }
    @GetMapping("/szia")
    public String hello() {
        return "szia";
    }
}


