package com.busreservation.example.busreservation.service;

import com.busreservation.example.busreservation.entities.Bus;

import java.util.List;

public interface BusService {

   Bus addBus(Bus bus);

   List<Bus> getAllBus();


}
