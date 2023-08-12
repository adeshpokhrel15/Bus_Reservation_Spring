package com.busreservation.example.busreservation.controller;

import com.busreservation.example.busreservation.entities.BusSchedule;
import com.busreservation.example.busreservation.model.ResponseModel;
import com.busreservation.example.busreservation.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class BusScheduleController
{
    private BusScheduleService busScheduleService;
    @Autowired
    public BusScheduleController(BusScheduleService thebusScheduleService){
        busScheduleService = thebusScheduleService;
    }

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addBusSchedule(@RequestBody BusSchedule busSchedule) {
        final BusSchedule schedule = busScheduleService.addSchedule(busSchedule);
        return  new ResponseModel<>(HttpStatus.OK.value(), "Schedule saved", schedule);


    }

    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getBusSchedule(){
        return ResponseEntity.ok(busScheduleService.getAllBusSchedule());
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<List<BusSchedule>> getBusSchedule(
            @PathVariable(name = "routeName")
            String routeName
    ){
        return ResponseEntity.ok(busScheduleService.getScheduleByRoute(routeName));
    }

}
