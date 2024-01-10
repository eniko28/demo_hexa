package com.example.demo.adapter.out.persistence;

import com.example.demo.application.domain.entity.Plant;
import com.example.demo.application.port.out.PlantOutputPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long>, PlantOutputPort {

    Optional<Plant> findByNameAndType(String name, String type);
}
