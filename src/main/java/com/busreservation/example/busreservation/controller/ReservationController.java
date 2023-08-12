package com.busreservation.example.busreservation.controller;

import com.busreservation.example.busreservation.entities.Reservation;
import com.busreservation.example.busreservation.model.ResponseModel;
import com.busreservation.example.busreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService){
        reservationService = reservationService;
    }

    @PostMapping("/add")
    public ResponseModel<Reservation> addReservation(@RequestBody Reservation reservation){
        final Reservation res = reservationService.addReservation(reservation);
        return new ResponseModel<>(HttpStatus.OK.value(), "Reservation saved", res);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    @GetMapping("/query")
    public ResponseEntity<List<Reservation>> getReservationByScheduleAndDepartureDate(
            @RequestParam Long scheduleId,
            @RequestParam String departureDate
    ){
        return ResponseEntity.ok(reservationService.getReservationsByScheduleAndDepartureDate(
                scheduleId,
                departureDate
        ));
    }

    @GetMapping("/add/{mobile}")
    public ResponseEntity<List<Reservation>> getReservationByMobile(
            @PathVariable(name="mobile") String mobile
    ) {
        return ResponseEntity.ok(reservationService.getReservationsByMobile(mobile));
    }



}
