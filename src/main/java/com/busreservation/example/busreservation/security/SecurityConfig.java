//package com.busreservation.example.busreservation.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests(
//
//                )
//                .requestMatchers(HttpMethod.GET)
//                .permitAll()
//                .authenticated()
//                .and()
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//
//    }
//}
