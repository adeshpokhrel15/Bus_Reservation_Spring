package com.busreservation.example.busreservation.controller;


import com.busreservation.example.busreservation.entities.Bus;
import com.busreservation.example.busreservation.repositories.BusRepository;
import com.busreservation.example.busreservation.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")

public class BusController {

    private BusService busService;
    @Autowired
    public BusController(BusService thebusService) {
    busService = thebusService;
    }

    @PostMapping("/add")
    public String addBus(@RequestBody Bus bus){
            busService.addBus(bus);
            return "saved bus";
    }

    @GetMapping("/all")
    public List<Bus> getAllBuses(){
        return busService.getAllBus();

    }

}
