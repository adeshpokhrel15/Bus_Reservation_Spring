package com.busreservation.example.busreservation.service.Impl;

import com.busreservation.example.busreservation.entities.BusRoute;
import com.busreservation.example.busreservation.model.ReservationApiException;
import com.busreservation.example.busreservation.repositories.BusRrouteRepository;
import com.busreservation.example.busreservation.service.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteImpl implements BusRouteService {

   private BusRrouteRepository busRouteRepository;
   @Autowired
   public BusRouteImpl(BusRrouteRepository thebusRouteRepository){
       busRouteRepository = thebusRouteRepository;
   }
    @Override
    public BusRoute addRoute(BusRoute busRoute){
        return busRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
        return busRouteRepository.findByRouteName(routeName).orElseThrow(
                () -> new ReservationApiException(
                        HttpStatus.BAD_REQUEST,
                        "Route Not Found"
                )

        );
    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findByCityFromAndCityTo(cityFrom,cityTo).orElseThrow(
                () -> new ReservationApiException(
                        HttpStatus.BAD_REQUEST,
                        "Route Not Found"
                )

        );
    }
}
