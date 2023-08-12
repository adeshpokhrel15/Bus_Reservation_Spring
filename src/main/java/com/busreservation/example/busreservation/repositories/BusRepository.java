package com.busreservation.example.busreservation.repositories;

import com.busreservation.example.busreservation.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {




}
