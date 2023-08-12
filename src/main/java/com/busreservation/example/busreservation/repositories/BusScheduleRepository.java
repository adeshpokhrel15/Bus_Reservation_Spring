package com.busreservation.example.busreservation.repositories;

import com.busreservation.example.busreservation.entities.Bus;
import com.busreservation.example.busreservation.entities.BusRoute;
import com.busreservation.example.busreservation.entities.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long> {
    Optional<List<BusSchedule>> findByBusroute(BusRoute busRoute);

    Boolean existsByBusAndBusrouteAndDepartureTime(Bus bus, BusRoute busRoute, String date);
}
