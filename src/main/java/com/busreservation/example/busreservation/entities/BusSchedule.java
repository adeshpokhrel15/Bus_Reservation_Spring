package com.busreservation.example.busreservation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "route_id")
    private BusRoute busroute;

    private String departureTime;

    private Integer discount;

    private Integer processingFee;

}
