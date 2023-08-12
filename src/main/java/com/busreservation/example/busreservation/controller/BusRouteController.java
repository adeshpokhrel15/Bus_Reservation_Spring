package com.busreservation.example.busreservation.controller;

import com.busreservation.example.busreservation.entities.BusRoute;
import com.busreservation.example.busreservation.model.ResponseModel;
import com.busreservation.example.busreservation.service.BusRouteService;
import com.busreservation.example.busreservation.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class BusRouteController {
    private BusRouteService busRouteService;

    @Autowired
    public BusRouteController(BusRouteService theBusService){
        busRouteService = theBusService;
    }

    @PostMapping("/add")
    public ResponseModel<BusRoute> addRoute(@RequestBody BusRoute busRoute){
        final BusRoute busRoute1= busRouteService.addRoute(busRoute);
        return new ResponseModel<>(HttpStatus.OK.value(), "Route Saved", busRoute1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusRoute>> getAlLRoutes(){
        return ResponseEntity.ok(busRouteService.getAllBusRoutes());
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<BusRoute> getRouteByRouteName(@PathVariable(name="routeName") String routeName){
        return ResponseEntity.ok(busRouteService.getRouteByRouteName(routeName));
    }

    @GetMapping("/query")
    public ResponseEntity<BusRoute> getRouteByCityFromAndCityTO(
            @RequestParam String cityFrom,
            @RequestParam String cityTo){
        return ResponseEntity.ok(busRouteService.getRouteByCityFromAndCityTo(cityFrom,cityTo));
    }
}
