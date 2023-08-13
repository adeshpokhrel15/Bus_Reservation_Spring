package com.busreservation.example.busreservation.service;

import com.busreservation.example.busreservation.entities.AppUsers;
import com.busreservation.example.busreservation.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    private AppUserRepository appUserRepository;
    @Autowired
    public CustomerUserDetailService(AppUserRepository theappUserRepository){
        appUserRepository = theappUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      final AppUsers appUsers = appUserRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User does not exist"));
        return User.builder()
                .username(appUsers.getUserName())
                .password(appUsers.getPassword())
                .roles(appUsers.getRole())
                .build();
    }
}
