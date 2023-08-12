package com.busreservation.example.busreservation.service.Impl;

import com.busreservation.example.busreservation.entities.BusSchedule;
import com.busreservation.example.busreservation.entities.Customer;
import com.busreservation.example.busreservation.entities.Reservation;
import com.busreservation.example.busreservation.model.ReservationApiException;
import com.busreservation.example.busreservation.repositories.BusScheduleRepository;
import com.busreservation.example.busreservation.repositories.CustomerRepository;
import com.busreservation.example.busreservation.repositories.ReservationRepository;
import com.busreservation.example.busreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    private CustomerRepository customerRepository;

    private BusScheduleRepository busScheduleRepository;

    @Autowired
    public ReservationServiceImpl(
            ReservationRepository reservationRepository,
            CustomerRepository customerRepository,
            BusScheduleRepository busScheduleRepository
    ){
        reservationRepository = reservationRepository;
        customerRepository = customerRepository;
        busScheduleRepository = busScheduleRepository;

    }
    @Override
    public Reservation addReservation(Reservation reservation) {
        final Customer customer;
        final boolean doesCustomerExists = customerRepository.existsByMobileOrEmail(

                reservation.getCustomer().getEmail(),
                reservation.getCustomer().getMobile()

        );
        if(doesCustomerExists){
            customer = customerRepository.findByMobileOrEmail(reservation.getCustomer().getEmail(),
                    reservation.getCustomer().getMobile()).orElseThrow();


        } else {
            customer = customerRepository.save(reservation.getCustomer());
        }
        reservation.setCustomer(customer);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduledId, String departureData) {
        final BusSchedule schedule = busScheduleRepository.findById(scheduledId)
                .orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "Schedule not found"));
        return reservationRepository.findByBusScheduleAndDepartureDate(schedule,departureData)
                .orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "Reservation not found"));

    }

    @Override
    public List<Reservation> getReservationsByMobile(String mobile) {
        final Customer customer = customerRepository.findByMobile(mobile)  .orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "Reservation not found"));
            return reservationRepository.findByCustomer(customer)  .orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "Reservation not found"));

    }
}
