package com.busreservation.example.busreservation.service.Impl;

import com.busreservation.example.busreservation.entities.BusRoute;
import com.busreservation.example.busreservation.entities.BusSchedule;
import com.busreservation.example.busreservation.model.ReservationApiException;
import com.busreservation.example.busreservation.repositories.BusRrouteRepository;
import com.busreservation.example.busreservation.repositories.BusScheduleRepository;
import com.busreservation.example.busreservation.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BusScheduleServiceImpl implements BusScheduleService {

    private BusScheduleRepository busScheduleRepository;
    private BusRrouteRepository busRrouteRepository;
    @Autowired
    public BusScheduleServiceImpl(BusScheduleRepository theBusScheduleRepository, BusRrouteRepository thebusRrouteRepo){
        busScheduleRepository = theBusScheduleRepository;
        busRrouteRepository = thebusRrouteRepo;
    }
    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) {
        final boolean exists = busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(
                busSchedule.getBus(),
                busSchedule.getBusroute(),
                busSchedule.getDepartureTime()
        );
        if (exists) {
            throw new ReservationApiException(HttpStatus.CONFLICT, "Duplicate Schedule");
        }
        return busScheduleRepository.save(busSchedule);
    }


    @Override
    public List<BusSchedule> getAllBusSchedule() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getScheduleByRoute(String routeName) {
        final BusRoute busRoute = busRrouteRepository.findByRouteName(routeName).orElseThrow(
                () -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Not found"));
        return busScheduleRepository.findByBusRoute(busRoute).orElseThrow(
                () -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Not found"));
    }
}
