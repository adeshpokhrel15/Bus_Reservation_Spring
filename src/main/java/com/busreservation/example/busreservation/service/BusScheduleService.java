package com.busreservation.example.busreservation.service;

import com.busreservation.example.busreservation.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {
    BusSchedule addSchedule(BusSchedule busSchedule);

    List<BusSchedule> getAllBusSchedule();

    List<BusSchedule> getScheduleByRoute(String routeName);
}
