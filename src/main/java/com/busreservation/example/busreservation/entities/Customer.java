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
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "mobile", unique = true)
    private String mobile;
    @Column(name = "email")
    private String email;
}
