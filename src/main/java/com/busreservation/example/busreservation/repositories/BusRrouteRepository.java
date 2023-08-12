package com.busreservation.example.busreservation.repositories;

import com.busreservation.example.busreservation.entities.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRrouteRepository extends JpaRepository<BusRoute,Long> {
    Optional<BusRoute> findByRouteName(String routeName);
    Optional<BusRoute> findByCityFromAndCityTo(String cityFrom, String cityTo);
}
