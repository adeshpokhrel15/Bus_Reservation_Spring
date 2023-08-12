package com.busreservation.example.busreservation.service.Impl;

import com.busreservation.example.busreservation.entities.Bus;
import com.busreservation.example.busreservation.repositories.BusRepository;
import com.busreservation.example.busreservation.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements BusService {

    private BusRepository busRepository;


    @Autowired
    public ServiceImpl(BusRepository thebusRepository){
        busRepository = thebusRepository;
    }
    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
}
