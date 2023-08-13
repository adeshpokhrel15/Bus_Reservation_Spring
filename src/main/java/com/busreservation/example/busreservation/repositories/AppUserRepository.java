package com.busreservation.example.busreservation.repositories;

import com.busreservation.example.busreservation.entities.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUsers,Long> {

    Optional<AppUsers> findByUserName(String userName);

}
