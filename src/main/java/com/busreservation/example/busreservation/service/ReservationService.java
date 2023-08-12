package com.busreservation.example.busreservation.service;

import com.busreservation.example.busreservation.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);

    List<Reservation> getAllReservation();

    List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduledId, String departureData);

    List<Reservation> getReservationsByMobile(String mobile);

}
