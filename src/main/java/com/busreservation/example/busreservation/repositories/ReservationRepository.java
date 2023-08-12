package com.busreservation.example.busreservation.repositories;

import com.busreservation.example.busreservation.entities.BusSchedule;
import com.busreservation.example.busreservation.entities.Customer;
import com.busreservation.example.busreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

Optional<List<Reservation>> findByCustomer(Customer customer);

Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule, String departureDate );

}
